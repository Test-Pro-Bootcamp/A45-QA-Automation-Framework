import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {

        inputEmail();
        inputPassword();
        clickLogin();
        deletePlaylistSvyeta();
        redButtonDeletePlaylist();
        getNotificationText();
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='alertify-logs top right']")).isDisplayed());
    }
}
