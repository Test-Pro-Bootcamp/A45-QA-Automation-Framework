import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.Keys;
public class Homework18 extends BaseTest {

    @Test
    public static void playSong() throws InterruptedException{

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        WebElement nextSongBtn = driver.findElement(By.cssSelector("footer#mainFooter i[title='Play next song']"));
        nextSongBtn.click();

        WebElement playBtn = driver.findElement(By.cssSelector("footer#mainFooter i.fa.fa-play"));
        playBtn.click();
        Thread.sleep(2000);

        WebElement soundBarIcon =driver.findElement(By.cssSelector("footer#mainFooter div.bars"));
        Assert.assertTrue(soundBarIcon.isDisplayed());
    }
}
