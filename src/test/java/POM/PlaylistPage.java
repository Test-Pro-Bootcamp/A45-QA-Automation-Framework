package POM;
import net.bytebuddy.asm.Advice;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.Keys;
public class PlaylistPage extends BasePage {

    public PlaylistPage (WebDriver givenDriver) {super (givenDriver);}

    public void deletePlaylist () {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[position()]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlistWrapper']//button[@class='del btn-delete-playlist']"))).click();

       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
    }
}
