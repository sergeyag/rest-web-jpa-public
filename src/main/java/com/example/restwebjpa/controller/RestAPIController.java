package com.example.restwebjpa.controller;

import com.example.restwebjpa.domain.Point;
import com.example.restwebjpa.repository.PointRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:8080"})
@RequestMapping("/restAPI")
public class RestAPIController {

    private final PointRepo pointRepo;

    @Autowired
    public RestAPIController( PointRepo pointRepo ) {
        this.pointRepo = pointRepo;
    }

    @GetMapping
    public List<Point> list() {
        return pointRepo.findAll();
    }

    @GetMapping("{id}")
    public Point getScenario(@PathVariable("id") Point point) {
        return point;
    }

}