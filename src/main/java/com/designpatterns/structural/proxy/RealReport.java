package com.designpatterns.structural.proxy;

public class RealReport implements Report{
    private final String reportName;

    public RealReport(String reportName) {
        this.reportName = reportName;
        loadFromDB();
    }

    private void loadFromDB() {
        System.out.println("Loading report from DB");
    }

    @Override
    public void display() {
        System.out.println("Displaying report");
    }
}
