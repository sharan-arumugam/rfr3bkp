package com.lti.rfr.service.mapper;

import org.springframework.stereotype.Service;

import com.lti.rfr.domain.FunctionalGroup;
import com.lti.rfr.service.dto.FunctionalGroupDTO;

/**
 * Mapper for the entity FunctionalGroup and its DTO FunctionalGroupDTO.
 */
@Service
public class FunctionalGroupMapper {

    public FunctionalGroup toEntity(FunctionalGroupDTO functionalGroupDTO) {
        return new FunctionalGroup(functionalGroupDTO);
    }

    public FunctionalGroupDTO toDto(FunctionalGroup functionalGroup) {
        return new FunctionalGroupDTO(functionalGroup);
    };

}
