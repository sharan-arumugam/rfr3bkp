package com.lti.rfr.service.dto;

import static com.lti.rfr.util.RfrUtil.RFR_FIELDS;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.lang.reflect.Field;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = { "requestId", "appleManager", "initiator" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class RfrRaw {

    private String requestId;
    private String status;
    private String requestTitle;
    private String requestType;
    private String businessType;
    private String sendDate;
    private String dueDate;
    private String appleManager;
    private String initiator;
    private String vendor;
    private String role;
    private String imt;
    private String imt1;
    private String imt2;
    private String rfpProjectType;
    private String rfpProjectModel;
    private String projectStartDate;
    private String projectEndDate;

    // user input
    private String skills;
    private String fulfilment;
    private String technology;
    private String location;
    private Integer onsiteHc;
    private Integer offshoreHc;

    public RfrRaw(Map<String, String> columnMap) {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                if (RFR_FIELDS.containsKey(field.getName())
                        && isNotBlank(columnMap.get(RFR_FIELDS.get(field.getName())))) {
                    field.set(this, columnMap.get(RFR_FIELDS.get(field.getName())));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
