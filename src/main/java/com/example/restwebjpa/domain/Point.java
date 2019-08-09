package com.example.restwebjpa.domain;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition="TEXT")
    private String text;
    private String subject;

    public Point(String text, String subject) {
        this.text = text;
        this.subject = subject;
    }

    public Point() {
    }
}
