package com.lti.rfr.service.mapper;

import com.lti.rfr.domain.*;
import com.lti.rfr.service.dto.FunctionalGroupDTO;
import com.lti.rfr.service.dto.RecieverDTO;

import org.mapstruct.*;
import org.springframework.stereotype.Service;

/**
 * Mapper for the entity Reciever and its DTO RecieverDTO.
 */
@Service
public class RecieverMapper{

    public RecieverDTO toDto(Reciever reciever) {
        return new RecieverDTO(reciever);
    }

    public Reciever toEntity(RecieverDTO recieverDTO) {
        return new Reciever(recieverDTO);
    }

}
