import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework20 extends BaseTest {

    @Parameters("baseUrl")
    @Test
    public static void launchBrowser(String baseUrl) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(baseUrl);
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl);

        String email = "kcroker@testpro.io";
        String password = "te$t$tudent";


        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(email);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylist.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.quit();


    }

}