package com.poc.userrole.service;

import com.poc.userrole.domain.BaseDomain;
import com.poc.userrole.dto.BaseDTO;
import com.poc.userrole.mapper.GenericMapper;
import com.poc.userrole.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Transactional
public abstract class GenericCrudService<D extends BaseDTO, E extends BaseDomain, PK extends Serializable> {

    protected GenericMapper<D, E> mapper;
    protected GenericRepository<E, PK> repository;

    public void createOrUpdate(D dto) {
        repository.save(mapper.toDomain(dto));
    }

    public void create(D dto) {
        repository.save(mapper.toDomain(dto));
    }

    public void createAll(List<D> dtos) {
        List<E> all = new ArrayList<>();

        dtos.forEach(one -> all.add(mapper.toDomain(one)));

        repository.saveAll(all);
    }

    public D read(PK id) {
        return mapper.toDTO(repository.findById(id).orElse(null));
    }

    public List<D> readAll() {
        List<D> all = new ArrayList<>();

        repository.findAll().forEach(one -> all.add(mapper.toDTO(one)));

        return all;
    }

    public boolean delete(PK id) {
        E domain = repository.findById(id).orElse(null);

        if (domain == null) {
            return false;
        }

        domain.setErased(true);

        repository.save(domain);

        return true;
    }

    @Autowired
    public void setMapper(GenericMapper<D, E> mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setRepository(GenericRepository<E, PK> repository) {
        this.repository = repository;
    }

}
