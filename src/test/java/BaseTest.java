import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    //Preconditions
    WebDriver driver;

    @BeforeMethod
    public void setUpBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }

    public void navigateToPage() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

    public void searchSong(String songName) {
        WebElement songField = driver.findElement(By.cssSelector("input[type='search']"));
        songField.click();
        songField.clear();
        songField.sendKeys(songName);
    }

    public void clickViewAllButton() {
        WebElement viewButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewButton.click();
    }
    public void clickFirstSongResult() {
        WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSong.click();
    }
    public void clickAddToButton() {
        WebElement addButton = driver.findElement(By.cssSelector("button.btn-add-to"));
        addButton.click();
    }
    public void choosePlaylist(){
        // To choose a playlist named TestPlaylist
        WebElement choosePlaylistElement = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'TestPlaylist')]"));
        choosePlaylistElement.click();
    }
    public String getNotificationText(){
        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return notificationText.getText();
    }

}