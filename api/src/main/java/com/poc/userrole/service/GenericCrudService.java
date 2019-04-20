package com.poc.userrole.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.poc.userrole.domain.BaseDomain;
import com.poc.userrole.dto.BaseDTO;
import com.poc.userrole.mapper.GenericMapper;
import com.poc.userrole.repository.GenericRepository;

public abstract class GenericCrudService<D extends BaseDTO, E extends BaseDomain, PK extends Serializable> {

    private GenericRepository<E, PK> repo;
    private GenericMapper<D, E> mapper;

    public void createOrUpdate(D dto) {
        repo.save(mapper.toDomain(dto));
    }

    public void createAll(List<D> dtos) {
        List<E> all = new ArrayList<>();

        dtos.forEach(one -> all.add(mapper.toDomain(one)));

        repo.saveAll(all);
    }

    public D read(PK id) {
        return mapper.toDTO(repo.findById(id).orElse(null));
    }

    public List<D> readAll() {
        List<D> all = new ArrayList<>();

        repo.findAll().forEach(one -> all.add(mapper.toDTO(one)));

        return all;
    }

    public boolean delete(PK id) {
        E domain = repo.findById(id).orElse(null);

        if (domain == null) {
            return false;
        }

        domain.setErased(true);

        repo.save(domain);

        return true;
    }

    @Autowired
    public void setRepo(GenericRepository<E, PK> repo) {
        this.repo = repo;
    }

    @Autowired
    public void setMapper(GenericMapper<D, E> mapper) {
        this.mapper = mapper;
    }

}
