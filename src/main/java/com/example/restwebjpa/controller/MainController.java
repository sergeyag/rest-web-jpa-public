package com.example.restwebjpa.controller;

import com.example.restwebjpa.domain.Point;
import com.example.restwebjpa.repository.PointRepo;
import com.example.restwebjpa.service.RestConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
@Slf4j
public class MainController {

    @Autowired
    private PointRepo pointRepo;

    @Autowired
    private RestConsumerService consumerService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String pointList(Model model) {
        model.addAttribute("points", pointRepo.findAll());
        return "pointList";
    }

    @GetMapping("/createNew")
    public String createNew() {
        return "pointNew";
    }

    @GetMapping("/load")
    public String loadData(Model model){

        try {
            List<Point> pointList = consumerService.getpointListFromRestApi(restTemplate);
            pointRepo.saveAll(pointList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("points", pointRepo.findAll());
        return "pointList";
    }

}
