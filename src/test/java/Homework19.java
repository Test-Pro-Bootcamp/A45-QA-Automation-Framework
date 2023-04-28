import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.InterruptedException;

public class Homework19 extends BaseTest {
    String deleteNotifyMsg = "Deleted playlist";

    @Test
    public void deletePlaylistTest() throws InterruptedException {
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        createNewPlaylistBtn();
        selectNewPlaylist();
        addNewPlaylistName("MyList");
        clickDeleteButton();
        verifyDelete();
        Assert.assertTrue(verifyDelete().contains(deleteNotifyMsg));
    }

    public String verifyDelete() {
        WebElement delNotify = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        return delNotify.getText();

    }

    public void clickDeleteButton() throws InterruptedException {
        WebElement deleteBtn = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        deleteBtn.click();
        Thread.sleep(2000);
    }

    public void addNewPlaylistName(String playlistName) throws InterruptedException {
        WebElement newPlaylist = driver.findElement(By.cssSelector("#playlists > form > input[type=text]"));
        newPlaylist.click();
        newPlaylist.sendKeys(playlistName);
        newPlaylist.submit();
        Thread.sleep(2000);
    }

    public void selectNewPlaylist() throws InterruptedException {
        WebElement newPlaylist = driver.findElement(By.cssSelector("#playlists > nav > ul > li:nth-child(1)"));
        newPlaylist.click();
        Thread.sleep(2000);
    }

    public void createNewPlaylistBtn() {
        WebElement playlistBtn = driver.findElement(By.cssSelector("i.fa.fa-plus-circle.create"));
        playlistBtn.click();
    }
}