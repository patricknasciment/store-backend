package com.patrick.store.resources;

import com.patrick.store.domain.Category;
import com.patrick.store.domain.Client;
import com.patrick.store.service.CategoryService;
import com.patrick.store.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        List<Client> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Integer id){
        Client client = service.findById(id);
        return ResponseEntity.ok().body(client);
    }

}
