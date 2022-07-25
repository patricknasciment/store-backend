package com.patrick.store.resources;

import com.patrick.store.domain.Category;
import com.patrick.store.repositories.CategoryRepository;
import com.patrick.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(path = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id){
        Category category = service.findById(id);
        return ResponseEntity.ok().body(category);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Category obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Void> update(@RequestBody Category obj,
                                           @PathVariable Integer id){
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
