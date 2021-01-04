package test;

import helper.ExcelReader;
import helper.TakeScreenShoot;
import helper.Util;
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

    String actualAlert;
    String actualTitle;

    @Test(dataProvider = "getData")
    public void LoginToApp(String userName, String password) throws IOException {

        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

        driver.get(Util.baseUrl);
        driver.findElement(By.name("uid")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("btnLogin")).click();


        try {
            Alert alert = driver.switchTo().alert();
            actualAlert = alert.getText();
            System.out.println(actualAlert);
            alert.accept();

            Assert.assertEquals(Util.expAlert, actualAlert);

        } catch (NoAlertPresentException ex) {
            actualTitle = driver.getTitle();

            Assert.assertEquals(Util.expectedTitle, actualTitle);

            //String pageText = driver.findElement(By.xpath("//tbody/tr[3]/td")).getText();
            TakeScreenShoot.screenShoot(driver);
        }

    }


    @DataProvider
    public Object[][] getData() {
        Object[][] data = null;
        try {
            data = ExcelReader.readExcelFile(new File("src/main/resources/files/Data.xlsx"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;

    }

}
