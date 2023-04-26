import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String playlistName = "zaikov-playlist";
        String successMessageFormat = "Added 1 song into \"%s.\"";

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        searchSong("Ketsa");
        clickViewAllBtn();
        selectFirstSong();
        clickAddToBtn();
        selectPlaylist(playlistName);
        Assert.assertEquals(getNotificationText(),  String.format(successMessageFormat, playlistName));


    }

    public String getNotificationText() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        System.out.println(notification.getText()+ "---Text");
        return notification.getText();

    }

    public void selectPlaylist(String playlistName) throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath(String.format("//section[@id='songResultsWrapper']//li[contains(text(),'%s')]", playlistName)));
        playlist.click();
    }

    public void clickAddToBtn() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToButton.click();
        Thread.sleep(2000);
    }

    public void selectFirstSong() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);
    }

    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }

    public void searchSong(String name) throws InterruptedException {
        WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
        search.sendKeys(name);
    }


}
