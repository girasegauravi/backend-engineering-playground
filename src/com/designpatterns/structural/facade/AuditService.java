package com.designpatterns.structural.facade;

class AuditService {
    public void log(String event) {
        System.out.println("Audit Log: " + event);
    }
}