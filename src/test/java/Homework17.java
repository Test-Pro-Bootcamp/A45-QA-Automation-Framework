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

    public void addSongToPlayList()throws InterruptedException {
// Added ChromeOptions argument below to fix websocket error

            String newSongAddedNotificationText = "Added 1 song";
            navigateToPage();
            provideEmail("daria.pavlyuk@testpro.io");
            providePassword("te$t$tudent");
            clickSubmit();
            searchSong("Dark Days");
            clickViewAllBtn();
            selectFirstSongResult();
            clickAddToBtn();
            choosePlaylist();
            Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));
        }

    public  void choosePlaylist() throws InterruptedException {
            WebElement playlistElement = driver.findElement(By.xpath("//section[@id = 'songResultsWrapper']//li[contains(text(), 'Test Pro Playlist')]"));
            playlistElement.click();
            Thread.sleep(2000);
    }
    public void clickViewAllBtn() throws InterruptedException {
            WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
            viewAllSearchResult.click();
            Thread.sleep(2000);
    }
    public void searchSong (String SongTitleKeyword) throws InterruptedException {
                WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search]"));
        searchField.sendKeys (SongTitleKeyword);
                Thread.sleep( 2000);
            }
//            public void clickViewAll8tn() throws InterruptedException {
//                WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
//                viewAllSearchResult.click();
//                Thread.sleep( 2000);
//            }
            public void selectFirstSongResult()throws InterruptedException {
                WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
                firstSongResult.click();
                Thread.sleep( 2000);
            }
//
            public void clickAddToBtn() throws InterruptedException {
                            WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
                            addToBtn.click();
                            Thread.sleep( 2000);

        }
//
//        public void choosePlayList() throws InterruptedException {
//            WebElement playlistElement = driver.findElement(By.xpath("//section[@id = 'songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"));
//                    playlistElement.click();
//                    Thread.sleep( 2000);
//        }
        public String getNotificationText () {
            WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
                                return notificationElement.getText();

                            }
}

