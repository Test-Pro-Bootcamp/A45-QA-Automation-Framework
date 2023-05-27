import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    @Test
    public void deletePlaylist() {
        provideEmail("anton.prymak@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        WebElement selectPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='playlist playlist']")));
        selectPlayList.click();

        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='del btn-delete-playlist']")));
        deletePlaylistButton.click();

        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
        Assert.assertTrue(confirmationMessage.isDisplayed());
    }
}