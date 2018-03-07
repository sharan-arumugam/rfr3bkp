package com.lti.rfr.service.mapper;

import org.springframework.stereotype.Service;

import com.lti.rfr.domain.Receiver;
import com.lti.rfr.service.dto.ReceiverDTO;

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
