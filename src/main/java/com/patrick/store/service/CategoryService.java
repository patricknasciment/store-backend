package com.patrick.store.service;

import com.patrick.store.domain.Category;
import com.patrick.store.repositories.CategoryRepository;
import com.patrick.store.service.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Integer id){
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Category insert(Category obj){
        obj.setId(null);
        return repository.save(obj);
    }

}
