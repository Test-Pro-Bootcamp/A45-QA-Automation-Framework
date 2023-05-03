import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomework extends BaseTest{

    @Test
    public void testMethod() {
        String playlistName = "kz-new playlist";
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
        WebElement search = driver.findElement(By.cssSelector("[type='search']"));
        search.sendKeys("Pluto");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.results h1 > button")));
        WebElement viewAll = driver.findElement(By.cssSelector("div.results h1 > button"));
        viewAll.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper td.title")));
        WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper td.title"));
        firstSong.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper button.btn-add-to")));
        WebElement addToButton = driver.findElement(By.cssSelector("section#songResultsWrapper button.btn-add-to"));
        addToButton.click();

        // search the playlist and click
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'kz-new playlist')]")));
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'kz-new playlist')]"));
        playlist.click();

        WebElement notif = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertEquals(notif.getText(), "Added 1 song into \"kz-new playlist.\"");
    }
}
