package com.example.model;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class CreateReportTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void createReportWithEmptyFileNameShouldCatchException() {

        exception.expect(Exception.class);
        CreateReport.createReport("", "");
    }

    @Test
    public void createReportTest() {
        CreateReport.createReport("TestReport", "Body for Test Report");
    }
}