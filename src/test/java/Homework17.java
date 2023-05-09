import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String newSongAddedNotificationText = "Added 1 song into";

        navigateToPage();
        provideEmail("rishkodaria@gmail.com");
        providePassword("2743782dasha!");
        clickSubmit();
        Thread.sleep(2000);

        createNewPlaylist("The Best");
        Thread.sleep(2000);

        searchSong("Pluto");
        clickViewAllBtn();

        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();

        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));
    }

    public void searchSong(String songTitleKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys("Pluto");
        Thread.sleep(2000);
    }

    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllSearchResult.click();
        Thread.sleep(2000);
    }

    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSongResult = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr"));
        firstSongResult.click();
        Thread.sleep(2000);
    }

    public void clickAddToBtn() throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
        Thread.sleep(2000);
    }

    public void choosePlaylist() throws InterruptedException {
        WebElement playlistElement = driver.findElement(By.cssSelector(
                "#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li.playlist"));
        playlistElement.click();
        Thread.sleep(2000);
    }

    public String getNotificationText() {
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
       return notificationElement.getText();
    }

    public void createNewPlaylist(String name) throws InterruptedException {
        WebElement newPlaylistElement = driver.findElement(By.cssSelector("i[title='Create a new playlist']"));
        newPlaylistElement.click();
        Thread.sleep(1000);

        WebElement newPlaylistButton = driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
        newPlaylistButton.click();
        Thread.sleep(2000);

        WebElement newPlaylistTextField = driver.findElement((
              By.cssSelector("form[name='create-simple-playlist-form'] input[placeholder='↵ to save']")));
        newPlaylistTextField.sendKeys(name);
        newPlaylistTextField.sendKeys(Keys.RETURN);
        Thread.sleep(2000);
    }

    public void waitAMoment() throws InterruptedException {
        Thread.sleep(2000);
    }
}