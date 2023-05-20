import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaylistPage {
    private WebDriver driver;

    @FindBy(id = "playlist-id")
    private WebElement playlistElement;

    public PlaylistPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void renamePlaylist(String newName) {
        playlistElement.click();
        playlistElement.clear();
        playlistElement.sendKeys(newName);
    }
}

import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}

public class TestScenario {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickLoginButton();

        PlaylistPage playlistPage = PageFactory.initElements(driver, PlaylistPage.class);
        playlistPage.renamePlaylist("New Playlist Name");


        driver.quit();
    }
}
