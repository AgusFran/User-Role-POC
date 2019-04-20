package com.poc.userrole.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.poc.userrole.domain.BaseDomain;
import com.poc.userrole.dto.BaseDTO;
import com.poc.userrole.service.GenericCrudService;

public abstract class GenericCrudController<D extends BaseDTO, E extends BaseDomain, PK extends Serializable> {

    private GenericCrudService<D, E, PK> crudService;

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
}
