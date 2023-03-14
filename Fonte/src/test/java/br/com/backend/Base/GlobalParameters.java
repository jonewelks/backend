package br.com.backend.Base;


import br.com.backend.Core.BaseTest;

public class GlobalParameters {

    private static BaseTest baseTest;
    private static String report;

    public static String reportName() {
        baseTest = new BaseTest();
        report = new StringBuilder()
                .append(baseTest.getSetupProperty("report.name"))
                .toString();
        return report;
    }
    public static String reportPath() {
        baseTest = new BaseTest();
        report = new StringBuilder()
                .append(baseTest.getSetupProperty("report.path"))
                .toString();
        return report;
    }
}
