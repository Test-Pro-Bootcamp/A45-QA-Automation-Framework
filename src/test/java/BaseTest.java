import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url = "";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @DataProvider(name="IncorrectLoginData")
    public static Object[][] getDataFromDataProviders() {

        return new Object[][] {
                {"invalid@mail.com", "invalidPass"},
                {"demo@class.com", ""},
                {"", ""}
        };
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        url = BaseURL;
        navigateToPage();
    }

    @AfterMethod//(enabled = false)
    public void closeBrowser() {
        driver.quit();
    }

    public static void navigateToPage() {
        driver.get(url);
    }

    public static void provideEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    public static void providePassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    public static void clickSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmit();
    }

    public static void clickSaveButton() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-submit")));
        saveButton.click();
    }

    public static void provideProfileName(String randomName) {
        ProfilePreferencesPage profilePreferencesPage = new ProfilePreferencesPage(driver);
        profilePreferencesPage.provideProfileName(randomName);
    }

    public static void provideCurrentPassword(String password) {
        ProfilePreferencesPage profilePreferencesPage = new ProfilePreferencesPage(driver);
        profilePreferencesPage.provideCurrentPassword(password);
    }

    public static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void clickAvatarIcon() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAvatarIcon();
    }

    // hover
    public void hoverPlay() {
        BasePage basePage = new BasePage(driver);
        basePage.hoverPlay();
    }

    // context click
    public void chooseAllSongsList() {
        BasePage basePage = new BasePage(driver);
        basePage.chooseAllSongsList();
    }

    public void contextClickFirstSong(){
        BasePage basePage = new BasePage(driver);
        basePage.contextClick(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
    }

    public void displayAllSongs() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.displayAllSongs();
    }

    // double click
    public void doubleClickChoosePlaylist() {
        HomePage homePage = new HomePage(driver);
        homePage.doubleClickFirstPlaylist();
    }
}