package com.project.preparation.practice.controller;


import com.project.preparation.practice.model.Data;
import com.project.preparation.practice.service.HibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    HibernateService service;

    @GetMapping("/database/upload/data")
    public ResponseEntity saveRandomData() {
        service.saveRandomData();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/database/get/data")
    public ResponseEntity getRandomData(){
        Data data = service.getData();
        System.out.println("--Get Random Data---");
        return ResponseEntity.ok(data);
    }
}
