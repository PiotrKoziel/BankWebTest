package test;

import helper.ExcelReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {

    private static String actualTitle;
    private static String expectedTitle;
    private static String actualAlert;
    private static String expAlert;

    @Test(dataProvider = "getData")
    public void LoginToApp(String userName, String password) {

        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

        driver.get("http://www.demo.guru99.com/V4/");
        driver.findElement(By.name("uid")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("btnLogin")).click();


        try {
            Alert alert = driver.switchTo().alert();
            actualAlert = alert.getText();
            System.out.println(actualAlert);
            expAlert = "User or Password is not valid";
            alert.accept();

            Assert.assertEquals(expAlert, actualAlert);

        } catch (NoAlertPresentException ex) {
            actualTitle = driver.getTitle();
            expectedTitle = "Guru99 Bank Manager HomePage";

            Assert.assertEquals(expectedTitle, actualTitle);

        }

    }

    @DataProvider
    public Object[][] getData() {
        Object [][] data = null;
        try{
            data = ExcelReader.readExcelFile(new File("src/main/resources/files/Data.xlsx"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;

    }

}
