import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest {

    @Test
    public void playSongTest() {
        provideEmail("elliott.nance@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        clickPlay();
    }

    public void clickPlay() {
        WebElement playNextSong = driver.findElement(By.cssSelector("div.side.player-controls > i.next.fa.fa-step-forward.control"));
        WebElement playOrResumeButton = driver.findElement(By.cssSelector("div.side.player-controls > span > span.play"));
        playNextSong.click();
        playOrResumeButton.click();
        WebElement notif = driver.findElement(By.cssSelector("div.side.player-controls > span > span.pause"));
    }
}

