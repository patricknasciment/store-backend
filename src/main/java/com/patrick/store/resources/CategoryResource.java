package com.patrick.store.resources;

import com.patrick.store.domain.Category;
import com.patrick.store.repositories.CategoryRepository;
import com.patrick.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){

        List<Category> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

}
