package com.patrick.store.dto;

import com.patrick.store.domain.Category;

import java.io.Serial;
import java.io.Serializable;

public class CategoryDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public CategoryDTO(){}

    public CategoryDTO(Category category){
        this.id = category.getId();
        this.name = category.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
