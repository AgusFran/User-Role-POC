package com.poc.userrole.mapper;

import com.poc.userrole.domain.BaseDomain;
import com.poc.userrole.dto.BaseDTO;

public interface GenericMapper<D extends BaseDTO, E extends BaseDomain> {

    public E toDomain(D dto);
    public D toDTO(E domain);

}
