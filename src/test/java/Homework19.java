import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    private WebElement driver;

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
