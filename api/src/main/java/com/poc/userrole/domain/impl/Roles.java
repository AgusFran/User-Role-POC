package com.poc.userrole.domain.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.poc.userrole.domain.BaseDomain;

@Entity
public class Roles implements BaseDomain{

    @Id
    @Column
    private int id;

    @Column
    private String description;

    @Column
    private boolean erased;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isErased() {
        return erased;
    }

    public void setErased(boolean erased) {
        this.erased = erased;
    }

}
