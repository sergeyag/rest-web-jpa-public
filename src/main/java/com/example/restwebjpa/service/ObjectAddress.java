package com.example.restwebjpa.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class ObjectAddress implements Serializable {

    @JsonProperty("PostalCode")
    private String postalCode;

    @JsonProperty("Address")
    private String address;

    public String getAddress() {
        return address;
    }
}
