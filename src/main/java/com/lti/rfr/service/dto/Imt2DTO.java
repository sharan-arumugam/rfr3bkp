package com.lti.rfr.service.dto;

import java.util.List;

import lombok.Data;

@Data
public class Imt2DTO {

    private String id;
    private String name;
    private List<String> children;
    private boolean selected;

}
