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
    public void playASongTest() throws InterruptedException {

        login("demo@class.com", "te$t$tudent");
        playSong();
        Assert.assertTrue(isSongPlaying());
    }

    public void playSong() {
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid = 'play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));//added missing square bracket xpaths

        playNextButton.click();
        playButton.click();
    }
    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));//removed extra space in xpath
        return soundBar.isDisplayed();

    }
}


