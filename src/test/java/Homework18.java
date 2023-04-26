import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.InterruptedException;

public class Homework18 extends BaseTest {

    @Test
    public void playSongTest() throws InterruptedException {
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        clickPlayNextSong();
        clickPlayButton();
        Assert.assertTrue(isSongPlaying());
    }

    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.cssSelector(".bars > img"));
        return soundBar.isDisplayed();
    }

    public void clickPlayButton() throws InterruptedException {
        WebElement playBtn = driver.findElement(By.cssSelector("span.play > i"));
        playBtn.click();
        Thread.sleep(2000);
    }

    public void clickPlayNextSong() throws InterruptedException {
        WebElement nextSongBtn = driver.findElement(By.cssSelector("i.next.fa.fa-step-forward.control"));
        nextSongBtn.click();
        Thread.sleep(4000);
    }
}