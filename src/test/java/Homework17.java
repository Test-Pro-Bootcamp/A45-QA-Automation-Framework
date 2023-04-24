import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() {
        String newSongAddedNotificationText = "Added 1 song into";

        // Steps
        navigateToPage();
        provideEmail("bolormaa.zanabaatar@testpro.io");
        providePassword("te$t$tudent");
        try{
            clickSubmit();
            searchSong("Pluto");
            clickViewAllBtn();
            selectFirstSongResult();
            clickAddToBtn();
            choosePlaylist();
        }catch (InterruptedException ex){

        }

        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));
    }

    public void searchSong(String songTitleKeyboard) throws InterruptedException{
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search]"));
        searchField.sendKeys(songTitleKeyboard);
        Thread.sleep(2000);
    }

    public void clickViewAllBtn() throws InterruptedException{
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllSearchResult.click();
        Thread.sleep(2000);
    }

    public void selectFirstSongResult() throws InterruptedException{
        WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSongResult.click();
        Thread.sleep(2000);
    }

    public void clickAddToBtn() throws InterruptedException{
        WebElement addTooBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addTooBtn.click();
        Thread.sleep(2000);
    }

    public void choosePlaylist() throws InterruptedException{
        WebElement playList = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'student')]"));
        playList.click();
        Thread.sleep(5000);
    }

    public String getNotificationText(){
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();
    }
}