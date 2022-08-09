package com.patrick.store.dto;

import com.patrick.store.domain.Client;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;

public class ClientDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 8, max = 120,
            message = "O tamanho deve ser entre 8 - 120 caracteres")
    private String name;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "email inválido")
    private String email;

    public ClientDTO() {
    }

    public ClientDTO(Client obj){
        this.id = obj.getId();
        this.name = obj.getEmail();
        this.email = obj.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
