package com.project.preparation.practice;

import org.flywaydb.core.Flyway;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class PracticeApplication {


    public static void main(String[] args) throws HibernateException {
        SpringApplication.run(PracticeApplication.class, args);
    }
}
