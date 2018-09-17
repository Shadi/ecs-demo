package com.github.ecsdemo.config;

import com.blacklocus.metrics.CloudWatchReporter;
import com.blacklocus.metrics.CloudWatchReporterBuilder;
import com.codahale.metrics.MetricRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MetricsConfig {

    @Bean
    CloudWatchReporter cloudWatchReporter(MetricRegistry metricRegistry) {
        return new CloudWatchReporterBuilder()
                .withNamespace("ecsDemo")
                .withRegistry(metricRegistry)
                .build();
    }

    @Bean
    MetricRegistry metricRegistry() {
        return new MetricRegistry();
    }

}
