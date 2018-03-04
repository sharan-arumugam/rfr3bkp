package com.lti.rfr.config;

import lombok.Getter;

@Getter
public enum RfrLocation {

    ONSITE("Onsite"),
    OFFSHORE("Offshore");

    private final String locationText;

    RfrLocation(String text) {
        locationText = text;
    }

    public static RfrLocation fromString(String text) {
        for (RfrLocation location : RfrLocation.values()) {
            if (location.locationText.equalsIgnoreCase(text)) {
                return location;
            }
        }
        return null;
    }

}
