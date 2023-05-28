import POM.HomePage;
import POM.LoginPage;
import POM.PlaylistPage;
import POM.AllSongsPage;
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

public class PlaylistTests extends BaseTest {
    @Test
    //@Parameters ({"BaseURL"})
    public static void createNewPlaylist() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.createNewPlaylist().successShowNotificationDisplayed();
    }
    @Test
    //@Parameters ({"BaseURL"})
    public static void renamePlaylist() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();

        String generatedName= RandomStringUtils.randomAlphabetic(10);
        homePage.doubleClickPlaylist().enterNewPlaylistName(generatedName).successShowNotificationDisplayed();
    }
    @Test
    //@Parameters ({"BaseURL"})
    public static void deletePlaylist() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login();
        homePage.createNewPlaylist();
        playlistPage.deleteEmptyPlaylist();
        homePage.successShowNotificationDisplayed();
    }
    @Test
    //@Parameters ({"BaseURL"})
    public static void addSongToPlaylist() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login();
        allSongsPage.openAllSongsPage().clickFirstSong().clickAddToBtn().clickAddFirstPlaylist();
        homePage.clickFirstPlaylist();
        playlistPage.firstSongIsPresent();
    }

}

