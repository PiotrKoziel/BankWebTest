
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {

    private static String actualTitle;
    private static String expectedTitle;
    private static String actualAlert;
    private static String expAlert;

    @Test
    public void LoginToApp() {

        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

        driver.get("http://www.demo.guru99.com/V4/");
        driver.findElement(By.name("uid")).sendKeys("mngr301929");
        driver.findElement(By.name("password")).sendKeys("avaqUhA");
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
}
