import POM.HomePage;
import POM.LoginPage;
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

public class Homework21 extends BaseTest {
    @Test
    @Parameters ({"BaseURL"})
    public static void renamePlaylist() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        navigateToPage(url);
        loginPage.login();
        homePage.doubleClickPlaylist().enterNewPlaylistName("NewPlaylist").successShowNotificationDisplayed();
    }
}
