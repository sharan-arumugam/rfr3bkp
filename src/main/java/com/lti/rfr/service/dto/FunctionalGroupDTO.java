package com.lti.rfr.service.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.lti.rfr.domain.FunctionalGroup;

/**
 * A DTO for the FunctionalGroup entity.
 */
public class FunctionalGroupDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String imt;

    private String imt1;

    private String imt2;

    public FunctionalGroupDTO() {

    }

    public FunctionalGroupDTO(RfrRaw rawRef) {
        imt = rawRef.getImt();
        imt1 = rawRef.getImt1();
        imt2 = rawRef.getImt2();
    }

    public FunctionalGroupDTO(FunctionalGroup functionalGroup) {
        id = functionalGroup.getId();
        imt = functionalGroup.getImt();
        imt1 = functionalGroup.getImt1();
        imt2 = functionalGroup.getImt2();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImt() {
        return imt;
    }

    public void setImt(String imt) {
        this.imt = imt;
    }

    public String getImt1() {
        return imt1;
    }

    public void setImt1(String imt1) {
        this.imt1 = imt1;
    }

    public String getImt2() {
        return imt2;
    }

    public void setImt2(String imt2) {
        this.imt2 = imt2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FunctionalGroupDTO functionalGroupDTO = (FunctionalGroupDTO) o;
//        if (functionalGroupDTO.getId() == null || getId() == null) {
//            return false;
//        }
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(getImt(), functionalGroupDTO.getImt())
                .append(getImt1(), functionalGroupDTO.getImt1())
                .append(getImt2(), functionalGroupDTO.getImt2());

        return builder.isEquals();// Objects.equals(getId(), functionalGroupDTO.getId());
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(getImt()).append(getImt1()).append(getImt2());

        return builder.toHashCode();
    }

    @Override
    public String toString() {
        return "FunctionalGroupDTO{" +
                "id=" + getId() +
                ", imt='" + getImt() + "'" +
                ", imt1='" + getImt1() + "'" +
                ", imt2='" + getImt2() + "'" +
                "}";
    }
}
