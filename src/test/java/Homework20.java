import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
// Remake of Homework19 (Homework19 itself was left the same)
    @Test
    public void deletePlaylist() {
        provideEmail("anton.prymak@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        WebElement selectPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='playlist playlist']")));
        selectPlayList.click();
//delete playlist
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='del btn-delete-playlist']")));
        deletePlaylistButton.click();
//confirmation
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
        Assert.assertTrue(confirmationMessage.isDisplayed());
    }
}