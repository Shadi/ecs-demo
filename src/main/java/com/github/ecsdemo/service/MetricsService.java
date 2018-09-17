package com.github.ecsdemo.service;

import com.blacklocus.metrics.CloudWatchReporter;
import com.codahale.metrics.MetricRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Service
public class MetricsService {

    private static final String VIEW = "view";

    private final MetricRegistry metricRegistry;
    private final CloudWatchReporter cloudWatchReporter;

    @Autowired
    public MetricsService(MetricRegistry metricRegistry, CloudWatchReporter cloudWatchReporter) {
        this.metricRegistry = metricRegistry;
        this.cloudWatchReporter = cloudWatchReporter;
    }

    @PostConstruct
    void reportToCloudWatch() {
        cloudWatchReporter.start(1, TimeUnit.SECONDS);
    }

    public void countView() {
        metricRegistry.counter(VIEW).inc();
    }
}
