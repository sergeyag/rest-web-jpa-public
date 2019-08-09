package com.example.restwebjpa.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class Kino implements Serializable {
    @JsonProperty("global_id")
    private Long global_id;

    @JsonProperty("Number")
    private int number;

    @JsonProperty("Cells")
    private Cells cells;

    public Long getGlobal_id() {
        return global_id;
    }

    public Cells getCells() {
        return cells;
    }
}
