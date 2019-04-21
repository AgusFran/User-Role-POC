package com.poc.userrole.service;

import com.poc.userrole.domain.BaseDomain;
import com.poc.userrole.dto.BaseDTO;
import com.poc.userrole.mapper.GenericMapper;
import com.poc.userrole.repository.GenericRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Transactional
public abstract class GenericCrudService<D extends BaseDTO, E extends BaseDomain, PK extends Serializable> {

    protected GenericRepository<E, PK> repository;
    protected GenericMapper<D, E> mapper;

    public GenericCrudService(GenericRepository<E, PK> repository, GenericMapper<D, E> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

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

    public GenericMapper<D, E> getMapper() {
        return mapper;
    }

    public GenericRepository<E, PK> getRepository() {
        return repository;
    }

}
