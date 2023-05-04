import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseT {

    @Test
    public void addSongsToPlayList() throws InterruptedException {
        String newSongAddedNotificationText = "Added 1 song into";
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        searchSong("Pluto");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlayList();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));
    }
    private void searchSong(String songTitleKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(songTitleKeyword); //firstSongResult.click();
        Thread.sleep(2000);
    }
    private void clickViewAllBtn() throws InterruptedException {
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllSearchResult.click();
        Thread.sleep(2000);

    }
public void selectFirstSongResult() throws InterruptedException {
    WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
    firstSongResult.click();
    Thread.sleep(2000);
}
    public void clickAddToBtn() throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
        Thread.sleep(2000);
    }
    private void choosePlayList() throws InterruptedException {
        // We created a playlist named "Test pro Playlist
        WebElement playlistElement = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"));
        playlistElement.click();
        Thread.sleep(2000);
    }

    public String getNotificationText() {
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();
    }
}
