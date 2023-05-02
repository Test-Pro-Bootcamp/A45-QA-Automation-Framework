import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[class='home active']")));

        WebElement playNextSong = driver.findElement(By.cssSelector("i[class='next fa fa-step-forward control']"));
        playNextSong.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i[class='next fa fa-step-forward control']")));

        WebElement playButton = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[data-testid='play-btn']")));
        playButton.click();

        WebElement PauseButton = driver.findElement(By.cssSelector("span[data-testid='pause-btn']"));
        Assert.assertTrue(PauseButton.isDisplayed());
    }
}