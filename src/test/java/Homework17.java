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

public class Homework17 extends BaseTest {

    @Test
    public void createPlaylist() throws InterruptedException {
        setupClass();
        launchBrowser();
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.click();
        searchField.sendKeys("Reactor");

        WebElement viewAllButton = driver.findElement(By.cssSelector("div.results h1 > button"));
        viewAllButton.click();
        Thread.sleep(2000);

        WebElement firstSongInList = driver.findElement(By.cssSelector("section#songResultsWrapper td.title"));
        firstSongInList.click();
        Thread.sleep(2000);

        WebElement addToButton = driver.findElement(By.cssSelector("section#songResultsWrapper button.btn-add-to"));
        addToButton.click();
        Thread.sleep(2000);

        WebElement createNewPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//ul/li[last()-85]"));
        createNewPlaylist.click();
        Thread.sleep(1000);

        WebElement successNotification = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertTrue(successNotification.isDisplayed());
        Assert.assertEquals(successNotification.getText(), "Added 1 song into \"1.My Playlist.\"");
    }
}
