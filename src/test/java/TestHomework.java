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

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']"))).click();
        WebElement search = driver.findElement(By.cssSelector("[type='search']"));
        search.sendKeys("Pluto");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.results h1 > button"))).click();
        //WebElement viewAll = driver.findElement(By.cssSelector("div.results h1 > button"));
        //viewAll.click();
        //Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper td.title"))).click();
        //WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper td.title"));
        //firstSong.click();
        //Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper button.btn-add-to"))).click();
        //WebElement addToButton = driver.findElement(By.cssSelector("section#songResultsWrapper button.btn-add-to"));
        //addToButton.click();
        //Thread.sleep(1000);

        // search the playlist and click
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'kz-new playlist')]"))).click();
        //WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'kz-new playlist')]"));
        //playlist.click();

        wait.until(ExpectedConditions.textToBe(By.cssSelector("div.success.show"),"Added 1 song into \"kz-new playlist.\""));
        //WebElement notif = driver.findElement(By.cssSelector("div.success.show"));
        //Assert.assertEquals(notif.getText(), "Added 1 song into \"kz-new playlist.\"");
    }
}
