package com.patrick.store.service;

import com.patrick.store.domain.Category;
import com.patrick.store.domain.Client;
import com.patrick.store.repositories.CategoryRepository;
import com.patrick.store.repositories.ClientRepository;
import com.patrick.store.service.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll(){
        return repository.findAll();
    }

    public Client findById(Integer id){
        Optional<Client> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

}
