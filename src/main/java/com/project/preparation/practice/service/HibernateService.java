package com.project.preparation.practice.service;

import com.project.preparation.practice.model.Data;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class HibernateService {

    private final LocalSessionFactoryBean factoryBean;

    @Autowired
    HibernateService(LocalSessionFactoryBean bean) {
        factoryBean = bean;
    }

    public void saveRandomData() throws HibernateException {

        final Session session = factoryBean.getObject().openSession();
        final Transaction transaction = session.beginTransaction();

        lisOfRandomObjects().stream().forEach(data -> session.merge(data));

        transaction.commit();
    }

    public Data getData() {
        final Session session = factoryBean.getObject().openSession();
        final Transaction transaction = session.beginTransaction();

        final HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        final JpaCriteriaQuery<Integer> query = criteriaBuilder.createQuery(Integer.class);

        query.select(criteriaBuilder.count(query.from(Data.class)).asInteger());

        final Integer singleResult = session.createQuery(query).getSingleResult();
        int randomInt = ThreadLocalRandom.current().nextInt(1, singleResult);

        final Data data = session.get(Data.class, randomInt);

        transaction.commit();

        return data; 
    }

    private List<Data> lisOfRandomObjects() {
        return IntStream.range(0, 10)
                .mapToObj(i -> new Data("Just a random data 2" + Math.random()))
                .collect(Collectors.toList());
    }

}
