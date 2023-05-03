import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.InterruptedException;

public class Homework20 extends BaseTest {
    String deleteNotifyMsg = "Deleted playlist";

    @Test
    public void deletePlaylistTest() throws InterruptedException {
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        openPlaylist();
        clickDeleteButton();
        clickOkToDelete();
        verifyDelete();
        Assert.assertTrue(verifyDelete().contains(deleteNotifyMsg));
    }


    public String verifyDelete() {
        WebElement delNotify = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.alertify-logs.top.right")));
        return delNotify.getText();
    }

    public void clickOkToDelete() {
        WebElement okBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(5) > div > div > nav > button.ok")));
        okBtn.click();
    }

    public void clickDeleteButton() {
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.del.btn-delete-playlist")));
        deleteBtn.click();
    }

    public void openPlaylist() {
        WebElement playlistToDelete = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        playlistToDelete.click();
    }
}