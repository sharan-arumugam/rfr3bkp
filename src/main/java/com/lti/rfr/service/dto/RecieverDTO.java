package com.lti.rfr.service.dto;

import java.io.Serializable;
import java.util.Objects;

import com.lti.rfr.domain.Reciever;

/**
 * A DTO for the Reciever entity.
 */
public class RecieverDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String psNumber;

    private String appleMail;

    private String name;

    private Long groupId;

    private String groupImt1;
    
    private String groupImt2;

    public RecieverDTO() {

    }

    public RecieverDTO(Reciever reciever) {
        id = reciever.getId();
        psNumber = reciever.getPsNumber();
        appleMail = reciever.getAppleMail();
        name = reciever.getName();
        groupId = reciever.getGroup().getId();
        groupImt1 = reciever.getGroup().getImt1();
        setGroupImt2(reciever.getGroup().getImt2());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPsNumber() {
        return psNumber;
    }

    public void setPsNumber(String psNumber) {
        this.psNumber = psNumber;
    }

    public String getAppleMail() {
        return appleMail;
    }

    public void setAppleMail(String appleMail) {
        this.appleMail = appleMail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long functionalGroupId) {
        this.groupId = functionalGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RecieverDTO recieverDTO = (RecieverDTO) o;
        if (recieverDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), recieverDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RecieverDTO{" +
                "id=" + getId() +
                ", psNumber='" + getPsNumber() + "'" +
                ", appleMail='" + getAppleMail() + "'" +
                ", name='" + getName() + "'" +
                "}";
    }

    public String getGroupImt1() {
        return groupImt1;
    }

    public void setGroupImt1(String groupImt1) {
        this.groupImt1 = groupImt1;
    }

    public String getGroupImt2() {
        return groupImt2;
    }

    public void setGroupImt2(String groupImt2) {
        this.groupImt2 = groupImt2;
    }
}
