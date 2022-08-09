package com.patrick.store.resources;

import com.patrick.store.domain.Client;
import com.patrick.store.domain.Client;
import com.patrick.store.dto.ClientDTO;
import com.patrick.store.service.ClientService;
import com.patrick.store.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @PutMapping(path = "{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ClientDTO objDto,
                                       @PathVariable Integer id){
        Client obj = service.fromDto(objDto);
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                         @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                         @RequestParam(value = "direction", defaultValue = "ASC") String direction){

        Page<Client> list = service.findPage(page,linesPerPage, orderBy, direction);
        Page<ClientDTO> listDto = list.map(x -> new ClientDTO(x));
        return ResponseEntity.ok().body(listDto);
    }

}
