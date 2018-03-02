package com.lti.rfr.config;

import lombok.Getter;

@Getter
public enum RfrStatus {

    NOT_RESPONDED("Not Responded"),
    PARTIALLY_RESPONDED("Partially Responded"),
    RESPONDED("Responded"),
    COMPLETED("Completed");

    private final String statusText;

    RfrStatus(String text) {
        statusText = text;
    }

    public static RfrStatus fromString(String text) {
        for (RfrStatus status : RfrStatus.values()) {
            if (status.statusText.equalsIgnoreCase(text)) {
                return status;
            }
        }
        return null;
    }
}
