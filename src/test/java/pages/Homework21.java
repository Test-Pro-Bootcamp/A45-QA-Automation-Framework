import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homework21 {
    public static void main(String[] args) {
        // Set up the WebDriver and open the desired webpage
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        // Create an instance of the Actions class
        Actions actions = new Actions(driver);

        // Find the playlist element you want to rename
        WebElement playlistElement = driver.findElement(By.id("playlist-id"));

        // Rename the playlist using Action class methods
        actions.moveToElement(playlistElement)
                .click()
                .sendKeys("New Playlist Name")
                .perform();

        // Implement explicit wait for the playlist name to be updated
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement updatedPlaylistElement = wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.id("playlist-id"), "New Playlist Name"));

        // Assert or perform further actions based on the updated playlist name

        // Quit the WebDriver
        driver.quit();
    }
}