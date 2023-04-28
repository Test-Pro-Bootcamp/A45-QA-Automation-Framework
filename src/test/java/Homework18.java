import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.bouncycastle.cms.RecipientId.password;

public class Homework18 extends BaseTest {
    @Test
    public void launchBrowser() {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void playASongTest() throws InterruptedException {

        login("demo@class.com", "te$t$tudent");
        playSong();
        Assert.assertTrue(isSongPlaying());
    }

    public void playSong() {
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid = 'play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span@data-testid='play-btn']"));

        playNextButton.click();
        playButton.click();
    }
    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play ']"));
        return soundBar.isDisplayed();

    }
}


