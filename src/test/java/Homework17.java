import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import java.lang.InterruptedException;

public class Homework17 extends BaseTest {


    String notificationMessage = "Added 1 song into ";
    @Test

    public void addSongToPlaylist() throws InterruptedException{

        navigateToPage();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickLoginButton();
        searchSong("Dark Days");
        viewAllButton();
        firstSongSearch();
        clickAddToButton();
        choosePlaylist();
        verifyNotification();
        Assert.assertTrue(verifyNotification().contains(notificationMessage));

    }

    public String verifyNotification() {
        WebElement addedSongNotification = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        return addedSongNotification.getText();
    }


public void choosePlaylist() throws InterruptedException {
    WebElement selectedPlaylist= driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'MyList')]"));
    selectedPlaylist.click();
    Thread.sleep(2000);
}


    public void clickAddToButton() throws InterruptedException  {
        WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToButton.click();
        Thread.sleep(2000);
    }



    public void firstSongSearch() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper td.title"));
        firstSong.click();
        Thread.sleep(2000);

    }

    public void viewAllButton() throws InterruptedException{
        WebElement viewAllButton = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllButton.click();
        Thread.sleep(2000);

    }

    public void searchSong(String song) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.sendKeys(song);
        Thread.sleep(2000);

    }

}



//    public void createPlaylist() throws InterruptedException {
//        WebElement newPlayList = driver.findElement(By.cssSelector("#playlists > form > input[type=text]"));
//        newPlayList.click();
//        newPlayList.sendKeys("MyNewList");
//        newPlayList.submit();
//        Thread.sleep(2000);
////        WebElement newPlaylist = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.new-playlist > form > input[type=text]"));
//    }