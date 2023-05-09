import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedNotificationText = "Deleted playlist \"kristina.matskaylo.\"";
        /*enterEmail("kristina.matskaylo@testpro.io");
        enterPassword("11111111*a");
        submitLogIn();*/
        navigateToPlaylist();
        clickRedBtnPlaylist();
        Assert.assertTrue(actualNotificationText().contains(expectedNotificationText));
    }
    public void navigateToPlaylist() throws InterruptedException{
        WebElement openMyPlaylist = driver.findElement(By.xpath("//section[@id='playlists']/ul/li[3]"));
        openMyPlaylist.click();
        Thread.sleep(2000);
    }
    public void clickRedBtnPlaylist() throws  InterruptedException{
        WebElement redBtnDeletePlaylist = driver.findElement(By.xpath("//div[@data-test='song-list-controls']//button[@title='Delete this playlist']"));
        redBtnDeletePlaylist.click();
        Thread.sleep(2000);
    }

    public String actualNotificationText ()  {
        WebElement getActualNotificationText = driver.findElement(By.cssSelector("div.success.show"));
        return getActualNotificationText.getText();
    }

}
