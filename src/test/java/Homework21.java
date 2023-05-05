import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    public static void renamePlaylist() {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playlist:nth-child(3)")));
        WebElement choosePlaylist = driver.findElement(By.cssSelector("li.playlist:nth-child(3)"));
        actions.doubleClick(choosePlaylist).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        WebElement inputPlaylistNameField = driver.findElement(By.cssSelector("input[name='name']"));
        actions.doubleClick(inputPlaylistNameField).click().perform();
        inputPlaylistNameField.sendKeys("Homework21");
        inputPlaylistNameField.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='success show']")));
        WebElement successMessage = driver.findElement(By.cssSelector("div[class='success show']"));
        Assert.assertEquals(successMessage.getText(), "Updated playlist \"Homework21.\"");
    }

    @Test
    public void renamePlaylistTest() {
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        renamePlaylist();
    }
}
