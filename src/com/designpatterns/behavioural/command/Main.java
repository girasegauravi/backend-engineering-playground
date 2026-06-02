package com.designpatterns.behavioural.command;

public class Main {
    public static void main(String[] args) {
        EmailService emailService = new EmailService();
        ReportService reportService = new ReportService();

        TaskQueue taskQueue = new TaskQueue();

        taskQueue.add(new EmailServiceCommand(
                emailService,
                "user@test.com",
                "Welcome!"
        ));

        taskQueue.add(new ReportServiceCommand(
                reportService,
                "Monthly Sales Report"
        ));

        taskQueue.runAll();
    }
}
