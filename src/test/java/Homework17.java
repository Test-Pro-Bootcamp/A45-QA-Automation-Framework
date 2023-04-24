import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        //preconditions set in BaseTest
        openLoginUrl();
        enterValidEmail("amanda.martins@testpro.io");
        enterValidPassword("te$t$tudent");
        clickSubmit();

        //test case call methods
        searchSong("dark days");
        clickViewAll();
        selectFirstSong();
        clickAddTo();
        selectPlaylist();
        verifyMessage();
    }

    public void searchSong(String title) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.sendKeys(title);
        Thread.sleep(2000);
    }

    public void clickViewAll() throws InterruptedException {
        WebElement viewAllButton = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllButton.click();
        Thread.sleep(2000);
    }

    public void selectFirstSong() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]"));
        firstSong.click();
        Thread.sleep(2000);
    }

    public void clickAddTo() throws InterruptedException {
        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        addTo.click();
        Thread.sleep(2000);
    }

    public void selectPlaylist() throws InterruptedException {
        WebElement addToPlaylist = driver.findElement(By.cssSelector("#songResultsWrapper li:nth-child(5)"));
        addToPlaylist.click();
        Thread.sleep(2000);
    }

    public void verifyMessage() throws InterruptedException {
        WebElement notificationMessage = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertTrue(notificationMessage.isDisplayed());
        Thread.sleep(2000);
    }


}
