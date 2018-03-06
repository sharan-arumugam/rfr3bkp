package com.lti.rfr.service.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//@EqualsAndHashCode(callSuper = false, of = { "name" })
public class ImtDTO {

    private String id;
    private String name;
    private List<Imt1DTO> children;
    private boolean selected;

}
