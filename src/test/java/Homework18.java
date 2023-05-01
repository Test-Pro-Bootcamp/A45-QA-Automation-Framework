import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

        WebElement playNextSong = driver.findElement(By.cssSelector("i[class='next fa fa-step-forward control']"));
        playNextSong.click();
        Thread.sleep(2000);

        WebElement playButton = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        playButton.click();
        Thread.sleep(2000);

        WebElement PauseButton = driver.findElement(By.cssSelector("span[data-testid='pause-btn']"));
        Assert.assertTrue(PauseButton.isDisplayed());


    }
}