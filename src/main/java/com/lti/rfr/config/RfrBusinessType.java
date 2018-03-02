package com.lti.rfr.config;

import lombok.Getter;

@Getter
public enum RfrBusinessType {

    NEW_BUSINESS("New Business"),
    RENEWAL("Renewal");

    private final String businessTypeText;

    RfrBusinessType(String text) {
        businessTypeText = text;
    }

    public static RfrBusinessType fromString(String text) {
        for (RfrBusinessType businessType : RfrBusinessType.values()) {
            if (businessType.businessTypeText.equalsIgnoreCase(text)) {
                return businessType;
            }
        }
        return null;
    }
}
