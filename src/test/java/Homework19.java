import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Homework19 {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    @Parameters("baseUrl")
    public void deletePlaylist(String baseUrl) {
        // Use the helper/reusable methods we created
        // ...

        // Navigate to the specified baseUrl
        driver.get(baseUrl);

        // Log in with your credentials
        login("deimante.juskyte@testpro.com", "te$t$tudent");

        // Click the playlist you want to delete or create a new playlist if not found
        WebElement playlist = findPlaylist("Lovers");
        if (playlist == null) {
            createPlaylist("New Playlist");
            playlist = findPlaylist("New Playlist");
        }
        playlist.click();

        // Click the "x PLAYLIST" button to delete the playlist
        WebElement deleteButton = driver.findElement(By.className("delete"));
        deleteButton.click();

        // Verify the confirmation notification
        WebElement confirmation = driver.findElement(By.className("confirmation-message"));
        String expectedText = "Deleted playlist " + playlist.getText();
        assertTextEquals(confirmation, expectedText);
    }

    // Helper/reusable methods
    private void login(String username, String password) {
        // Implementation
    }

    private WebElement findPlaylist(String playlistName) {
        // Implementation to find the playlist element based on the given name
        return null;
    }

    private void createPlaylist(String playlistName) {
        // Implementation to create a new playlist with the given name
    }

    private void assertTextEquals(WebElement element, String expectedText) {
        // Implementation to assert the text of the given element is equal to the expected text
    }
}

<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Homework19 Suite">
<test name="Homework19 Test">
<parameter name="baseUrl" value="https://bbb.testpro.io/" />
<classes>
<class name="pages.Homework19" />
</classes>
</test>
</suite>