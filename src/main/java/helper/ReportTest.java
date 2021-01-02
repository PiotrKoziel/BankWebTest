package helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.IOException;

public class ReportTest {



    public static void main(String[] args) throws IOException {

        ExtentHtmlReporter reporter= new ExtentHtmlReporter("index.html");
        ExtentReports reports = new ExtentReports();
        reports.attachReporter(reporter);


        ExtentTest test = reports.createTest("Our first test");
        test.log(Status.INFO, "First step");
        test.log(Status.ERROR, "Second step");
        test.log(Status.DEBUG, "Third step");
        test.pass("Test passed");

        test.pass("Description", MediaEntityBuilder.createScreenCaptureFromPath(".//src/main/resources/com" +
                ".traveler/747850000.png").build());

        reports.flush();
        reporter.flush();


    }

}
