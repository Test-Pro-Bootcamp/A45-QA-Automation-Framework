import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test
    public void deletePlaylistSvyeta() throws InterruptedException {

        inputEmail();
        inputPassword();
        clickLogin();
        clickPlaylistSvyeta();
        clickRedBtnDeletePlaylist();
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='alertify-logs top right']")) .isDisplayed());

    }
}

