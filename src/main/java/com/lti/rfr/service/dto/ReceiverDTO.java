package com.lti.rfr.service.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.lti.rfr.domain.Receiver;

public class ReceiverDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String psNumber;
    private String appleMail;
    private String name;
    private List<String> groups;

    public ReceiverDTO() {
        
    }

    public ReceiverDTO(Receiver reciever) {
        id = reciever.getId();
        psNumber = reciever.getPsNumber();
        appleMail = reciever.getAppleMail();
        name = reciever.getName();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReceiverDTO recieverDTO = (ReceiverDTO) o;
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

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }
}
