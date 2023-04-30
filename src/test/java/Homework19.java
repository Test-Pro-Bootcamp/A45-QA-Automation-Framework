import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.Collection;

//import static sun.security.jg's.GSSUtil.login;

public class Homework19 extends BaseTest {
    @Test

    public void deletePlaylist() throws InterruptedException {
        String deletedPlaylistMsg = "Deleted playlist";
        login("demo@class.com", "te$t$tudent");
        Thread.sleep(3000);
        openPlaylist();
        Thread.sleep(3000);

        //String deletedPlaylistMsg = "Deleted playlist";
        clickDeletePlaylistBtn();
        Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));
    }


    public void openPlaylist() {
        //WebElement emptyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3")));
        //emptyPlaylist.click();
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();

    }
    public void clickDeletePlaylistBtn() throws InterruptedException {

        //WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        //deletePlaylist.click();
        WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylist.click();
        Thread.sleep(3000);
    }

    public String getDeletedPlaylistMsg() {
        //WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        //return notificationMsg.getText();
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsg.getText();
    }
}





