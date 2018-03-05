package com.lti.rfr.service.mapper;

import com.lti.rfr.domain.*;
import com.lti.rfr.service.dto.FunctionalGroupDTO;
import com.lti.rfr.service.dto.ReceiverDTO;

import org.mapstruct.*;
import org.springframework.stereotype.Service;

/**
 * Mapper for the entity Reciever and its DTO RecieverDTO.
 */
@Service
public class RecieverMapper{

    public ReceiverDTO toDto(Receiver reciever) {
        return new ReceiverDTO(reciever);
    }

    public Receiver toEntity(ReceiverDTO recieverDTO) {
        return new Receiver(recieverDTO);
    }

}
