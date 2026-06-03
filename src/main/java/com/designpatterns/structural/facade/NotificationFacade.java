package com.designpatterns.structural.facade;


class NotificationFacade {

    private final TemplateService templateService;
    private final EmailService emailService;
    private final AuditService auditService;
    private final MetricsService metricsService;

    public NotificationFacade(
            TemplateService templateService,
            EmailService emailService,
            AuditService auditService,
            MetricsService metricsService
    ) {
        this.templateService = templateService;
        this.emailService = emailService;
        this.auditService = auditService;
        this.metricsService = metricsService;
    }

    public void sendPaymentSuccessNotification(String email) {

        String template =
                templateService.getTemplate("PAYMENT_SUCCESS");

        emailService.sendEmail(email, template);

        auditService.log("Payment success notification sent");

        metricsService.recordMetric("payment_success_email");
    }
}