package com.poc.userrole.mapper;

import com.poc.userrole.domain.BaseDomain;
import com.poc.userrole.dto.BaseDTO;

public interface GenericMapper<D extends BaseDTO, E extends BaseDomain> {

    E toDomain(D dto);
    D toDTO(E domain);

}
