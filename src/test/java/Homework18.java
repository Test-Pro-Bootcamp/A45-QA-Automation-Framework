import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSongTest() throws InterruptedException {
        navigateToPage();
        provideEmail("latha.baliga@testpro.io");
        providePassword("1te$t$tudent");
        clickSubmit();

        playaSong();
        Thread.sleep(2000);

        //Validate that a song is playing by verifying if the sound bar, or the pause button is displayed.
        WebElement pauseButton = driver.findElement(By.xpath("//span[@data-testid=\'pause-btn\']"));
        Assert.assertTrue(pauseButton.isDisplayed());
        Thread.sleep(2000);
    }
}
