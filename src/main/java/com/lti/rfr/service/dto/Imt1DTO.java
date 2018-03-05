package com.lti.rfr.service.dto;

import java.util.List;

import lombok.Data;

@Data
public class Imt1DTO {

    private String id;
    private String name;
    private List<Imt2DTO> children;
    private boolean selected;

}
