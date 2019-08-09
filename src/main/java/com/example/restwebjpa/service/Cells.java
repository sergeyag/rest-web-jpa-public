package com.example.restwebjpa.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

public class Cells implements Serializable {
    @JsonProperty("global_id")
    private Long id;

    @JsonProperty("CommonName")
    private String commonName;

    @JsonProperty("ObjectAddress")
    private List<ObjectAddress> objectAddressList;

    public String getCommonName() {
        return commonName;
    }

    public List<ObjectAddress> getObjectAddressList() {
        return objectAddressList;
    }
}
