package com.designpatterns.behavioural.command;

public class EmailServiceCommand implements Command {
    private final EmailService emailService;
    private final String email;
    private final String message;

    public EmailServiceCommand(EmailService emailService, String email, String message) {
        this.emailService = emailService;
        this.email = email;
        this.message = message;
    }

    public void execute() {
        emailService.sendEmail(email, message);
    }
}
