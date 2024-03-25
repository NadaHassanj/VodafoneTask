// ReportGenerator.java
package framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportGenerator {
    private ExtentReports extent;
    private ExtentTest test;

    public void initializeReport(String reportName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportName);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public void logStep(Status status, String stepName, String details) {
        switch (status) {
            case PASS:
                test.pass(stepName + ": " + details);
                break;
            case FAIL:
                test.fail(stepName + ": " + details);
                break;
            case SKIP:
                test.skip(stepName + ": " + details);
                break;
            default:
                break;
        }
    }

    public void attachScreenshot(String screenshotPath, String description) {
        try {
            test.addScreenCaptureFromPath(screenshotPath, description);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void finalizeReport() {
        extent.flush();
    }
}
