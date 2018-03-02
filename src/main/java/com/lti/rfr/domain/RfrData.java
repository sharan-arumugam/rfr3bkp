package com.lti.rfr.domain;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lti.rfr.service.dto.RfrRaw;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class RfrData {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String skills;
    private String fulfillment;
    private String technology;
    private String location;
    private Integer onsiteHc;
    private Integer offshoreHc;

    public RfrData(RfrRaw rawRef) {
        skills = rawRef.getSkills();
        fulfillment = rawRef.getFulfilment();
        technology = rawRef.getTechnology();
        location = rawRef.getLocation();
        onsiteHc = rawRef.getOnsiteHc();
        offshoreHc = rawRef.getOffshoreHc();
    }

}
