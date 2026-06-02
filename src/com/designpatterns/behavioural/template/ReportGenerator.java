package com.designpatterns.behavioural.template;

public abstract class ReportGenerator {
    public final void generateReport() {

        fetchData();

        validateData();

        exportReport();
    }

    private void fetchData() {
        System.out.println("Fetching report data");
    }

    private void validateData() {
        System.out.println("Validating report data");
    }

    protected abstract void exportReport();
}
