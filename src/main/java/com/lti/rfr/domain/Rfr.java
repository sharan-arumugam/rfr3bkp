package com.lti.rfr.domain;

import static com.lti.rfr.util.RfrUtil.formatRfrDate;
import static com.lti.rfr.util.RfrUtil.parseLongString;
import static com.lti.rfr.util.RfrUtil.parseRfrDate;
import static javax.persistence.EnumType.ORDINAL;
import static javax.persistence.EnumType.STRING;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lti.rfr.config.RfrBusinessType;
import com.lti.rfr.config.RfrStatus;
import com.lti.rfr.service.dto.RfrRaw;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false, of = { "requestId" })
@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rfr extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long requestId;

    @NotNull
    @Enumerated(ORDINAL)
    @JsonIgnore
    private RfrStatus status;

    @NotNull
    private String requestTitle;

    @NotNull
    private String requestType;

    @NotNull
    @Enumerated(STRING)
    @JsonIgnore
    private RfrBusinessType businessType;

    @NotNull
    @DateTimeFormat(iso = DATE)
    @JsonIgnore
    private LocalDate sendDate;

    @NotNull
    @DateTimeFormat(iso = DATE)
    @JsonIgnore
    private LocalDate dueDate;

    @NotNull(message = "'Apple Manager' cannot be blank")
    private String appleManager;

    @NotNull(message = "'Initiator' cannot be blank")
    private String initiator;

    private String vendor;

    private String role;

    @NotNull(message = "'IMT' cannot be blank")
    private String imt;

    private String imt1;

    private String imt2;

    private String rfpProjectType;

    private String rfpProjectModel;

    @DateTimeFormat(iso = DATE)
    @JsonIgnore
    private LocalDate projectStartDate;

    @DateTimeFormat(iso = DATE)
    @JsonIgnore
    private LocalDate projectEndDate;

    @OneToOne
    private RfrData data;

    public Rfr(RfrRaw rawRef) {
        requestId = parseLongString(rawRef.getRequestId());
        status = RfrStatus.fromString(rawRef.getStatus());
        requestTitle = rawRef.getRequestTitle();
        requestType = rawRef.getRequestType();
        businessType = RfrBusinessType.fromString(rawRef.getBusinessType());
        sendDate = parseRfrDate(rawRef.getSendDate());
        dueDate = parseRfrDate(rawRef.getDueDate());
        appleManager = rawRef.getAppleManager();
        initiator = rawRef.getInitiator();
        vendor = rawRef.getVendor();
        role = rawRef.getRole();
        imt = rawRef.getImt();
        imt1 = rawRef.getImt1();
        imt2 = rawRef.getImt2();
        rfpProjectType = rawRef.getRfpProjectType();
        rfpProjectModel = rawRef.getRfpProjectModel();
        projectStartDate = parseRfrDate(rawRef.getProjectStartDate());
        projectEndDate = parseRfrDate(rawRef.getProjectEndDate());
        data = new RfrData(rawRef);
    }

    @JsonProperty("sendDate")
    public String sendDate() {
        return formatRfrDate(sendDate);
    }

    @JsonProperty("dueDate")
    public String dueDate() {
        return formatRfrDate(dueDate);
    }

    @JsonProperty("projectStartDate")
    public String projectStartDate() {
        return formatRfrDate(projectStartDate);
    }

    @JsonProperty("projectEndDate")
    public String projectEndDate() {
        return formatRfrDate(projectEndDate);
    }

    @JsonProperty("status")
    public String status() {
        return status.getStatusText();
    }

    @JsonProperty("businessType")
    public String businessType() {
        return businessType.getBusinessTypeText();
    }

}
