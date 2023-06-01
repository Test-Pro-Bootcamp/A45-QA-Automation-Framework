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
    public void addSongToPlaylist() throws InterruptedException{

//  //added these to baseTest
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--disable-notifications");

//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
//        Thread.sleep(1000);

//        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
//        emailField.click();
//        emailField.clear();
//        emailField.sendKeys("esther.martinez32@gmail.com");
//        Thread.sleep(1000);
        provideEmail();
//        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
//        passwordField.click();
//        passwordField.clear();
//        passwordField.sendKeys("Proverbs99!");
//        Thread.sleep(1000);
        providePassword();
//        WebElement logIn = driver.findElement(By.cssSelector("button[type='submit']"));
//        logIn.click();
        logInButton();
//        WebElement usersAvatar = driver.findElement(By.cssSelector("img.avatar"));
//        Assert.assertTrue(usersAvatar.isDisplayed());
//        Thread.sleep(1000);
        assertAvatar();
//        WebElement songSearch = driver.findElement(By.cssSelector("input[name='q']"));
//        songSearch.click();
//        songSearch.sendKeys("hand");
//        Thread.sleep(1000);
        searchSong();
//        WebElement viewAll = driver.findElement(By.cssSelector("section.songs h1 button"));
//        viewAll.click();
//        Thread.sleep(1000);
        viewSongs();
//        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//table[@class='items']/tr[1]/td[2]"));
//        firstSong.click();
//        Thread.sleep(1000);
        findFirstSong();
//        WebElement addTo = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[2]"));
//        addTo.click();
//        Thread.sleep(1000);
        addSong();
//        WebElement playList = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[7]"));
//        playList.click();
//        Thread.sleep(2000);
        playlist17();
//        WebElement verification = driver.findElement(By.xpath("//div[@class='success show']"));
//        Thread.sleep(2000);
//        Assert.assertEquals(verification.getText(), "Added 1 song into \"homework17.\"");
        success();
//  //after method in baseTest
//        driver.quit();
    }
}
