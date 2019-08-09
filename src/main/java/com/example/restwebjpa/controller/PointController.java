package com.example.restwebjpa.controller;

import com.example.restwebjpa.domain.Point;
import com.example.restwebjpa.repository.PointRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/point")
public class PointController {
    @Autowired
    PointRepo pointRepo;


    @GetMapping
    public String pointList(Model model) {
        model.addAttribute("points", pointRepo.findAll());
        return "pointList";
    }

    @GetMapping("{point}")
    public String pointViewForm(@PathVariable Point point, Model model) {
        model.addAttribute("point", point);
        return "pointView";
    }

    @GetMapping("{point}/{action}")
    public String pointForm(@PathVariable Point point, @PathVariable String action, Model model) {
        model.addAttribute("point", point);
        if(action.compareTo("view") == 0) {
            return "pointView";
        }else if(action.compareTo("delete") == 0){
            pointRepo.delete(point);
            return "pointList";
        }else{
            return "pointEdit";
        }
    }

    @PostMapping
    public String pointSave(
            @RequestParam String subject,
            @RequestParam String text,
            @RequestParam("msgId") Point point
    ) {

        if(point == null){
            point = new Point(subject, text);
        }else {
            point.setSubject(subject);
            point.setText(text);
        }
        pointRepo.save(point);

        return "redirect:/point/" + point.getId() + "/view";
    }
}