package com.poc.userrole.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E, P extends Serializable> extends JpaRepository<E, P>, JpaSpecificationExecutor<E> {
}