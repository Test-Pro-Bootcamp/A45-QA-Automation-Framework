import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playNextSong() throws InterruptedException {

        inputEmail();
        inputPassword();
        clickLogin();
        findTestProPlaylistHome();
        clickFirstSongInTestProPlaylist();
        clickNextSong();
        clickPlayButton();
        Assert.assertTrue(driver.findElement(By.cssSelector("div[data-testid='sound-bar-play']")) .isDisplayed());
    }
}
