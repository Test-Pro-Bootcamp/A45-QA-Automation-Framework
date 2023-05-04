package POM;
import org.apache.commons.lang3.RandomStringUtils;
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
public class HomePage extends BasePage {

    By userAvatarIcon = By.cssSelector("img.avatar");
    By successShowNotification = By.xpath("//div[@class='success show']");

    String randomPlaylistName = RandomStringUtils.randomAlphabetic(10);

    public HomePage (WebDriver givenDriver) {
        super (givenDriver);
    }

    public WebElement getUserAvatar () {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }

    public void createNewPlaylist () {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//i[@title='Create a new playlist']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[@data-testid='playlist-context-menu-create-simple']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//input[@name='name']"))).click();
        WebElement newPlaylistName = driver.findElement(By.xpath("//section[@id='playlists']//input[@name='name']"));

        newPlaylistName.sendKeys("AutomatedNewPlaylist" + Keys.ENTER);
    }

    public void deletePlaylist () {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[position()]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlistWrapper']//button[@class='del btn-delete-playlist']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
    }

    public void successShowNotificationDisplayed () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
        WebElement successNotification = driver.findElement(successShowNotification);
        Assert.assertTrue(successNotification.isDisplayed());
    }
}
