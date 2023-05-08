import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String newSongAddedNotificationText = "Added 1 song into";

        navigateToPage();
        waitAMoment();

        provideEmail("rishkodaria@gmail.com");
        waitAMoment();

        providePassword("2743782dasha!");
        waitAMoment();

        clickSubmit();
        waitAMoment();

        searchSong("Pluto");
        clickViewAllBtn();
        waitAMoment();

        selectFirstSongResult();
        waitAMoment();

        clickAddToBtn();
        waitAMoment();

        choosePlaylist();
        waitAMoment();

        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));

        for(int i = 0; i < 15; i++)
            waitAMoment();
    }

    public void waitAMoment() throws InterruptedException
    {
        Thread.sleep(1000);
    }

    public void searchSong (String songTitleKeyword) throws InterruptedException{
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search]"));
        searchField.sendKeys(songTitleKeyword);
        Thread.sleep(2000);
    }

    public void clickViewAllBtn () throws InterruptedException{
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllSearchResult.click();
        Thread.sleep(2000);
    }

    public void selectFirstSongResult() throws InterruptedException{
        WebElement firstSongResult = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr"));
        firstSongResult.click();
        Thread.sleep(2000);
    }

    public void clickAddToBtn() throws InterruptedException{
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
        Thread.sleep(2000);
    }

    public void choosePlaylist() throws InterruptedException{
        WebElement playlistElement = driver.findElement(
                By.cssSelector("#songResultsWrapper li.favorites"));

        playlistElement.click();
        Thread.sleep(2000);
    }

    public String getNotificationText() {
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();
    }
}











