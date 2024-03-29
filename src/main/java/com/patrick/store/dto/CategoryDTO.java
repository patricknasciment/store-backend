package com.patrick.store.dto;

import com.patrick.store.domain.Category;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class CategoryDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5,max = 80, message = "0 - 80 caracteres")
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
