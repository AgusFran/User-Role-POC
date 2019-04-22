package com.poc.userrole.controller;

import com.poc.userrole.domain.BaseDomain;
import com.poc.userrole.dto.BaseDTO;
import com.poc.userrole.service.GenericCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public abstract class GenericCrudController<D extends BaseDTO, E extends BaseDomain, PK extends Serializable> {

    private GenericCrudService<D, E, PK> crudService;

    public GenericCrudController(GenericCrudService<D, E, PK> crudService) {
        this.crudService = crudService;
    }

    @PutMapping
    public void update(@RequestBody D dto) {
        this.crudService.createOrUpdate(dto);
    }

    @PostMapping
    public void createAll(@RequestBody List<D> all) {
        this.crudService.createAll(all);
    }

    @GetMapping
    public List<D> readAll() {
        return this.crudService.readAll();
    }

    @GetMapping("{id}")
    public D read(@PathVariable("id") PK id) {
        return this.crudService.read(id);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") PK id) {
        return this.crudService.delete(id);
    }

    @Autowired
    public void setService(GenericCrudService<D, E, PK> service) {
        this.crudService = service;
    }

    public GenericCrudService<D, E, PK> getService() {
        return crudService;
    }
}
