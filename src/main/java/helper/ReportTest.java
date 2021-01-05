package helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ReportTest {


    public static void main(String[] args) {

        ExtentHtmlReporter reporter = new ExtentHtmlReporter("index.html");
        ExtentReports reports = new ExtentReports();
        reports.attachReporter(reporter);


        ExtentTest test = reports.createTest("Our first test");
        test.log(Status.INFO, "First step");
        test.log(Status.ERROR, "Second step");
        test.log(Status.DEBUG, "Third step");
        test.pass("Test passed");

        reports.flush();
        reporter.flush();

    }
}
