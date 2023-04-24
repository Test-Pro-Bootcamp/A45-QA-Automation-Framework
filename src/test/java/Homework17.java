import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {
    @Test
    public static void addSongToPlaylist() throws InterruptedException {

        String newSongAdded = "Added 1 Song";

        navigateToPage();
        provideEmail("kcroker@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        searchSong("Callaita");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertTrue(getNotificationText().contains(newSongAdded));

    }

    public static void searchSong(String songTitle) throws InterruptedException{
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(songTitle);
        Thread.sleep(2000);
    }

    public static void clickViewAllBtn() throws InterruptedException {
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllSearchResult.click();
        Thread.sleep(2000);
    }

    public static void selectFirstSongResult() throws InterruptedException {
        WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSongResult.click();
        Thread.sleep(2000);
    }

    public static void clickAddToBtn() throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
        Thread.sleep(2000);
    }

    public static void choosePlaylist() throws InterruptedException {
        WebElement playlistElement = driver.findElement(By.xpath("//section[@id ='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"));
        playlistElement.click();
        Thread.sleep(2000);
    }

    public static String getNotificationText(){
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();
    }
}
