import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String newSongAddedNotificationText = "Added 1 song into";

        navigateToPage();
        provideEmail("ericgraves75@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        searchSong("BossStatus");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlayList();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));
    }

    private void choosePlayList() throws InterruptedException {
        WebElement playlistElement = driver.findElement(By.xpath("//section[@id ='songResultsWrapper']//li[contains(text(),'1st')]"));
        playlistElement.click();
        Thread.sleep(2000);
    }

    private String getNotificationText() {
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();
    }

    private void clickAddToBtn() throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
        Thread.sleep(2000);
    }

    private void selectFirstSongResult() throws InterruptedException {
        WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSongResult.click();
        Thread.sleep(2000);
    }

    private void clickViewAllBtn() throws InterruptedException {
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllSearchResult.click();
        Thread.sleep(2000);
    }

    private void searchSong(String BossStatus) throws  InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search]"));
        searchField.sendKeys(BossStatus);
        Thread.sleep(2000);
    }
}