import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class Homework18 extends  BaseTest {
    public void playSong() throws InterruptedException{
        //openLogInPage();
        enterEmail("kristina.matskaylo@testpro.io");
        enterPassword("11111111*a");
        submitLogIn();
        clickPlayNextSongButton();
        clickPlayButton();
        Assert.assertTrue(songPlaying());
    }

    private void clickPlayNextSongButton() throws InterruptedException{
        WebElement playNextSongButton = driver.findElement(By.xpath("//*[@title='Play next song']"));
        playNextSongButton.click();
        Thread.sleep(2000);
    }
    private void clickPlayButton() throws InterruptedException {
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playButton.click();
        Thread.sleep(2000);
    }
    public boolean songPlaying(){
        WebElement soundBar = driver.findElement(By.xpath("//button[@data-testid='toggle-visualizer-btn']"));
        return soundBar.isDisplayed();
    }
}
