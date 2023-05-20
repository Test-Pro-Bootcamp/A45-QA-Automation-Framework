import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaylistPage {
    private WebDriver driver;
    private By playlistElement = By.id("playlist-id");

    public PlaylistPage(WebDriver driver) {
        this.driver = driver;
    }

    public void renamePlaylist(String newName) {
        WebElement playlist = driver.findElement(playlistElement);
        playlist.click();
        playlist.clear();
        playlist.sendKeys(newName);
    }

    public boolean isPlaylistRenamed(String expectedName) {
        WebElement playlist = driver.findElement(playlistElement);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.textToBePresentInElementValue(playlist, expectedName));
    }
}

import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By loginButton = By.id("login-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }
}

import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;

public class TestScenario {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();

        PlaylistPage playlistPage = new PlaylistPage(driver);
        playlistPage.renamePlaylist("New Playlist Name");

        // Perform further actions or assertions
        boolean isRenamed = playlistPage.isPlaylistRenamed("New Playlist Name");
        System.out.println("Playlist renamed successfully: " + isRenamed);

        driver.quit();
    }
}


