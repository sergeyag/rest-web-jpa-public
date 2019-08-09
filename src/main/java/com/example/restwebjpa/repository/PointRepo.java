package com.example.restwebjpa.repository;

import com.example.restwebjpa.domain.Point;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PointRepo extends CrudRepository<Point, Long> {
    List<Point> findAll();
}
