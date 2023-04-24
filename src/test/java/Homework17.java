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
    public void addSongToPlaylist(){
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

        WebElement searchBar = driver.findElement(By.cssSelector("input[type='search']"));
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys("reactor");

        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllButton.click();

        WebElement songReactor = driver.findElement(By.xpath("//td[contains(text(), 'Reactor')]"));
        //WebElement songReactor = driver.findElement(By.cssSelector("tr[class='song-item selected']"));
        songReactor.click();

        WebElement addToButton = driver.findElement(By.cssSelector("button[class = 'btn-add-to']"));
        addToButton.click();

        WebElement playlistHW17 = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(5)"));
        playlistHW17.click();

        WebElement successMessage = driver.findElement(By.cssSelector("body > div.alertify-logs.top.right > div"));

        Assert.assertTrue(successMessage.isDisplayed());
        driver.quit();
    }
}
