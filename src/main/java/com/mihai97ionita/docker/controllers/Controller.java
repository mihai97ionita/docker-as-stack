package com.mihai97ionita.docker.controllers;


import com.mihai97ionita.docker.model.Shop;
import com.mihai97ionita.docker.repository.Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/controller")
public class Controller {

    @Autowired
    Repository repository;

    @GetMapping
    public ResponseEntity<List<Shop>> getAll()
    {
        List<Shop> shopList = repository.findAll();
        System.out.println(shopList);
        if(shopList.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(shopList, HttpStatus.OK);
    }

}
