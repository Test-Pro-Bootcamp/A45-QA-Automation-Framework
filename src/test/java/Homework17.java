import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedNotificationText = "Added 1 song into";
        openLogInPage();
        enterEmail("kristina.matskaylo@testpro.io");
        enterPassword("11111111*a");
        submitLogIn();
        searchSong("Beautiful");
        clickViewAllButton();
        selectFirstSongFromSearchResult();
        clickAddToButton();
        choosePlayListToAdd();
        Assert.assertTrue(actualNotificationText().contains(expectedNotificationText));




}

    public void searchSong(String songname) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys(songname);
        searchField.click();
        Thread.sleep(2000);

    }
    public void clickViewAllButton()  throws InterruptedException  {
        WebElement buttonViewAll = driver.findElement(By.cssSelector("section.songs h1 button"));
        buttonViewAll.click();
        Thread.sleep(2000);
    }
    public void selectFirstSongFromSearchResult()  throws InterruptedException {
        WebElement firstSongFromList = driver.findElement(By.cssSelector("#songResultsWrapper td.title"));
        firstSongFromList.click();
        Thread.sleep(2000);
    }

    public void clickAddToButton() throws InterruptedException  {
        WebElement buttonAddTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        buttonAddTo.click();
        Thread.sleep(2000);
    }

    public void choosePlayListToAdd()  throws InterruptedException {
        WebElement uniquePlayList = driver.findElement(By.xpath("// section[@id='songResultsWrapper']//li[contains(text(),'kristina.matskaylo')]"));
        uniquePlayList.click();
        Thread.sleep(2000);
    }

        public String actualNotificationText ()  {
        WebElement getActualNotificationText = driver.findElement(By.cssSelector("div.success.show"));
        return getActualNotificationText.getText();

        }




}
