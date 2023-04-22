import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest{

    @Test

    public static void addSongToPlaylist() throws InterruptedException {

    //      Added ChromeOptions argument below to fix websocket error
    ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

    WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    String url = "https://bbb.testpro.io/";  //Navigate to "https://bbb.testpro.io/"
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        // Login with your credentials
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("demo@class.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(2000);
        //Search for a song (choose any song of your choice)
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.click();
        searchField.sendKeys("Samurai");
        Thread.sleep(2000);
        //Click to view All Songs
        WebElement allSongsOption = driver.findElement(By.cssSelector("a[class='songs']"));
        allSongsOption.click();
        Thread.sleep(2000);
        //Click the first song in the 'All Songs' playlist
        WebElement firstSongInList = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]"));
        firstSongInList.click();
        Thread.sleep(2000);
        //Click 'Add to' the playlist button
        WebElement addToPlaylistButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToPlaylistButton.click();
        //Choose the playlist 'Test Pro playlist' to add the song
        WebElement playlistName = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/header/div[3]/div/section[1]/ul/li[63]"));
        playlistName.click();
        Thread.sleep(5000);
        //Verify that the notification message has the text 'Added 1 song into Test Pro playlist'
        //Verify that the notification message appears at the right top of the screen
       Assert.assertTrue(driver.findElement(By.cssSelector("div[class='alertify-logs top right']")).isDisplayed());



        driver.quit();

    }

}
