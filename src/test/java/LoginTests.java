import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public static void loginEmptyEmailPasswordTest() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public static void loginSuccessTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
//        Assert.assertEquals(driver.getCurrentUrl(), url);
        WebElement emailField =driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("demo@class.com");

        WebElement passwordField =driver.findElement(By.cssSelector("[type ='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.submit();

        WebElement usersAvatar = driver.findElement(By.cssSelector("[alt='Avatar of 6b285ed58ab6434aa036914159253be3']"));
        Assert.assertTrue(usersAvatar.isDisplayed());
        driver.quit();
    }
    @Test
    public static void IncorrectLogin(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("invalid@class.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");


        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(),url);
        driver.quit();

    }




    }








