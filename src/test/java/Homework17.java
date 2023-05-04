import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() {
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[class='home active']")));

        WebElement songSearch = driver.findElement(By.cssSelector("input[type='search']"));
        songSearch.sendKeys("Pluto");

        WebElement viewAll = driver.findElement(By.cssSelector("div.results h1 > button"));
        viewAll.click();

        WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper td.title"));
        firstSong.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper td.title")));

        WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-add-to")));

        WebElement addToPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'julia play')]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'julia play')]")));
        addToPlaylist.click();

        WebElement notif = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertEquals(notif.getText(), "Added 1 song into \"julia play.\"");
    }
}