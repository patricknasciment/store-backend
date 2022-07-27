package com.patrick.store.resources;

import com.patrick.store.domain.Category;
import com.patrick.store.dto.CategoryDTO;
import com.patrick.store.repositories.CategoryRepository;
import com.patrick.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<Category> list = service.findAll();
        List<CategoryDTO> listDto = list.stream()
                .map(x -> new CategoryDTO(x)).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id){
        Category category = service.findById(id);
        return ResponseEntity.ok().body(category);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CategoryDTO objDto){
        Category obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody CategoryDTO objDto,
                                           @PathVariable Integer id){
        Category obj = service.fromDto(objDto);
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

        Page<Category> list = service.findPage(page,linesPerPage, orderBy, direction);
        Page<CategoryDTO> listDto = list.map(x -> new CategoryDTO(x));
        return ResponseEntity.ok().body(listDto);
    }
}
