package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {


    protected WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.out.println("Before test");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterTest
    public void tearDown(){
        System.out.println("After test");
        driver.quit();
    }



}
