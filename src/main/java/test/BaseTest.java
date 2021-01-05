package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {


    protected WebDriver driver;
    protected ExtentHtmlReporter reporter;
    protected ExtentReports reports;


    @BeforeTest
    public void setUpReporter() {
        reporter = new ExtentHtmlReporter("src/main/resources/reports/index.html");
        reports = new ExtentReports();
        reports.attachReporter(reporter);
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before test");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After test");
        driver.quit();
    }


    @AfterTest
    public void tearDownReporter() {
        reporter.flush();
        reports.flush();
    }



    }
