package com.patrick.store.service;

import com.patrick.store.domain.Client;
import com.patrick.store.domain.Client;
import com.patrick.store.dto.ClientDTO;
import com.patrick.store.repositories.ClientRepository;
import com.patrick.store.repositories.ClientRepository;
import com.patrick.store.service.exeptions.DataIntegrityException;
import com.patrick.store.service.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public Client update(Client obj){
        Client newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    public void delete(Integer id){
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("It's not possible to delete a client due constrain.");
        }

    }

    public Page<Client> findPage(Integer page,
                                   Integer linesPerPage,
                                   String orderBy,
                                   String direction){
        PageRequest pageRequest = PageRequest.of(page,
                linesPerPage,  Sort.Direction.valueOf(direction), orderBy);

        return repository.findAll(pageRequest);
    }

    public Client fromDto(ClientDTO objDto){
        return new Client(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null);
    }

    private void updateData(Client newObj, Client obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

}
