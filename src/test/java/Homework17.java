import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest {

    @Test

    public void addSongToPlaylist() throws InterruptedException {

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

        WebElement songSearch = driver.findElement(By.cssSelector("input[type='search']"));
        songSearch.sendKeys("Pluto");

        WebElement viewAll = driver.findElement(By.cssSelector("div.results h1 > button"));
        viewAll.click();
        Thread.sleep(2000);

        WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper td.title"));
        firstSong.click();
        Thread.sleep(2000);

        WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToButton.click();
        Thread.sleep(2000);

        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'julia play')]"));
        playlist.click();
        Thread.sleep(2000);

        WebElement notif = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertEquals(notif.getText(), "Added 1 song into \"julia play.\"");

    }
}