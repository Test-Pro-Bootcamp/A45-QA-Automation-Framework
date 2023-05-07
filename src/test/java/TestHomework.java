import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomework extends BaseTest{

    @Test
    public void testMethod() throws InterruptedException {

        String playlistName = "kz-new playlist";
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']"))).sendKeys("Pluto");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.results h1 > button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper td.title"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper button.btn-add-to\""))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'kz-new playlist')]"))).click();
        WebElement notif = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertEquals(notif.getText(), "Added 1 song into \"kz-new playlist.\"");
    }
}
