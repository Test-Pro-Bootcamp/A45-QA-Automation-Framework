import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test

    public static void addSongToPlaylist() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();//not needed
        emailField.clear();
        emailField.sendKeys("demo@class.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();//not needed
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        WebElement searchBar = driver.findElement(By.cssSelector("input[type='search']"));
        searchBar.click();//not needed
        searchBar.clear();
        searchBar.sendKeys("Dark Days");

        WebElement viewAll = driver.findElement(By.cssSelector("div.results h1 button"));
        viewAll.click();

        WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
firstSong.click();

        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        addTo.click();

        WebElement addingToPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[@class='playlist'][normalize-space()='HW']"));
        addingToPlaylist.click();


        WebElement successAlert = driver.findElement(By.cssSelector("div.success.show"));
        successAlert.getText();


    }
}