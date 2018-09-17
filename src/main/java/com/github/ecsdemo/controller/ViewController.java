package com.github.ecsdemo.controller;

import com.github.ecsdemo.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {

    private final MetricsService metricsService;

    @Autowired
    public ViewController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @RequestMapping("/")
    public String view() {
        metricsService.countView();
        return "viewed";
    }
}
