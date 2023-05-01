import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() {
        String expectedNotificationText = "Deleted playlist \"kristina.matskaylo.\"";
        enterEmail("kristina.matskaylo@testpro.io");
        enterPassword("11111111*a");
        submitLogIn();
        navigateToPlaylist();
        clickDeletePlaylist();
        Assert.assertTrue(actualNotificationText().contains(expectedNotificationText));
    }
    public void navigateToPlaylist() {
        WebElement openMyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']/ul/li[3]")));
        openMyPlaylist.click();

    }
    public void clickDeletePlaylist() {
        WebElement redBtnDeletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-test='song-list-controls']//button[@title='Delete this playlist']")));
        redBtnDeletePlaylist.click();

    }

    public String actualNotificationText ()  {
        WebElement getActualNotificationText = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
        return getActualNotificationText.getText();
    }

}

