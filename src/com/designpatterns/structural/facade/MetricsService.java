package com.designpatterns.structural.facade;

class MetricsService {
    public void recordMetric(String metric) {
        System.out.println("Metric Recorded: " + metric);
    }
}