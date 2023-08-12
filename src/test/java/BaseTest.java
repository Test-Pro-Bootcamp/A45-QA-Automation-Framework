import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class BaseTest {
    public WebDriver driver = null;
    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();
    }
    public WebDriverWait wait = null;
    public Actions actions = null;
    public String url = "";
    public static ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    @BeforeMethod
    @Parameters({"baseURL"})
    public void setUpBrowser(@Optional String baseURL) throws MalformedURLException {
        url = baseURL;
        System.out.println(baseURL);
        THREAD_LOCAL.set(pickBrowser(System.getProperty("browser")));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getThreadLocal().get(baseURL);
        System.out.println(
                "Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getThreadLocal());

    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.160:4444";
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
        optionsChrome.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        switch (browser) {
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            return driver = new FirefoxDriver();
        case "MicrosoftEdge":
            WebDriverManager.edgedriver().setup();
            return driver = new EdgeDriver();
        case "grid-firefox":
            caps.setCapability("browserName", "firefox");
            return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
        case "grid-chrome":
            caps.setCapability("browserName", "chrome");
            return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
        case "grid-edge":
            caps.setCapability("browserName", "MicrosoftEdge");
            return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
        case "cloud":
            return lambdaTest();
        default:
            WebDriverManager.chromedriver().setup();
            return driver = new ChromeDriver(optionsChrome);
        }
    }

    public static WebDriver lambdaTest() throws MalformedURLException {
            String username = "adesinaikeoluwa4";
            String accessToken = "UkB4anX0vDCYCNesDCvetfDI2d9gBTJTEoncBQdnZG9XqzYrPr";
            String hubURL = "https://hub.lambdatest.com/wd/hub";

            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("114.0");
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("username", username);
            ltOptions.put("accessKey", accessToken);
            ltOptions.put("project", "Untitled");
            ltOptions.put("w3c", true);
            ltOptions.put("plugin", "java-testNG");
            browserOptions.setCapability("LT:Options", ltOptions);
            return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }
    @AfterMethod
    public void tearDown() {
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }
    public void navigateToPage() {
                getThreadLocal().get(url);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();
    }

    public void clickSaveButton() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-submit")));
        saveButton.click();
    }

    public void provideProfileName(String randomName) {
        WebElement profileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public void provideCurrentPassword(String password) {
        WebElement currentPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='current_password']")));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void clickAvatarIcon() {
        WebElement avatarIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img.avatar")));
        avatarIcon.click();
    }

    // hover
    public void hoverPlay() {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        // move to element
        actions.moveToElement(play).perform();
    }

    // context click
    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs")));
        driver.findElement(By.cssSelector("li a.songs")).click();
    }

    public void contextClickFirstSong(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        // context click
        actions.contextClick(firstSong).perform();
    }

    public void displayAllSongs() {
        chooseAllSongsList();
    //add assertion
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item")));
        List<WebElement> songsList = driver.findElements(By.cssSelector(".all-songs tr.song-item"));
        Assert.assertEquals(songsList.size(), 63);
    }

    // double click
    public void doubleClickChoosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        // double click
        WebElement playlist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        actions.doubleClick(playlist).perform();
    }

    public void searchSong (String songTitleKeyword) throws InterruptedException{
           WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search"));
            searchField.sendKeys(songTitleKeyword);
            Thread.sleep(2000);
            }
     public void clickViewAllBtn () throws InterruptedException {
          WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div.results h1 > button"));
           viewAllSearchResult.click();
            Thread.sleep(2000);
            }

    public void selectFirstSongResult () throws InterruptedException {
                WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
                firstSongResult.click();
                Thread.sleep(2000);

            }

    public void clickAddtoBtn() throws InterruptedException {
                WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
                addToBtn.click();
                Thread.sleep(2000);
            }

    public void choosePlaylist() throws InterruptedException {
                // We created a playlist named "Test Playlist"
                WebElement playlistElement = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Playlist')]"));
                playlistElement.click();
                Thread.sleep(2000);

            }

    public String getNotificationText() {
                WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
                return notificationElement.getText();

            }

    public void clickPlay() {
                WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
                WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

                playNextButton.click();
                playButton.click();
            }

    public boolean isSongPlaying() {
                WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
                return soundBar.isDisplayed();
            }

    public void openPlaylist() {
                WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
                emptyPlaylist.click();
            }

    public void clickDeletePlaylistBtn() throws InterruptedException {
                WebElement deletePlaylist = getThreadLocal().findElement(By.cssSelector(".btn-delete-playlist"));
                deletePlaylist.click();
            }

    public String getDeletedPlaylistMsg() {
                WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
                return notificationMsg.getText();
            }
}
