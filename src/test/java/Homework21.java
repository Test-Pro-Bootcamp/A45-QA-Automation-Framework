import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.Keys;

public class Homework21 extends BaseTest {
    @Test
    @Parameters ({"BaseURL"})
    public static void renamePlaylist() {

        navigateToPage(url);
        provideEmail("asdASD@mail.com");
        providePassword("te$t$tudent");
        clickSubmit();

        WebElement playlist = driver.findElement(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[position()]"));
        actions.doubleClick(playlist).perform();

        WebElement setPlaylistName = driver.findElement(By.xpath("//section[@id='playlists']//input[@name='name']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//input[@name='name']")));
        setPlaylistName.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        setPlaylistName.sendKeys("Renamed", Keys.ENTER);

        WebElement successNotification = driver.findElement(By.xpath("//div[@class='success show']"));
        Assert.assertTrue(successNotification.isDisplayed());
    }
}
