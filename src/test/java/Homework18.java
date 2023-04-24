import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18  extends BaseTest{

    @Test
    public static void playSong(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();//not needed
        emailField.clear();
        emailField.sendKeys("andrei.bryliakov@testpro.io");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();//not needed
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent1");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        WebElement nextSongButton = driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        nextSongButton.click();

        WebElement playSongButton = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        playSongButton.click();

        WebElement soundBar = driver.findElement(By.cssSelector("button[data-testid='toggle-visualizer-btn']"));

        Assert.assertTrue(soundBar.isDisplayed());

        driver.quit();
    }
}
