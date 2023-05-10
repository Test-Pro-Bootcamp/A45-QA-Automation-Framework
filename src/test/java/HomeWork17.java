import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

public class HomeWork17 extends BaseTest{

    @Test
    public void testMethod () throws InterruptedException {
        navigateToPage();
        provideEmail("pavel.furnic@testpro.io");
        providePassword("Test123456789@");
        clickSubmit();
        Thread.sleep(2000);

        WebElement search = driver.findElement(By.xpath("//input[@type = 'search']"));
        search.sendKeys("Pluto");

        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);

        WebElement firstRow = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//td[@class='title']"));
        firstRow.click();
        Thread.sleep(2000);

        WebElement addToButton =driver.findElement(By.xpath("//button[@class ='btn-add-to']"));
        addToButton.click();
        Thread.sleep(2000);

        WebElement addToPlayList =driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains (text(),'new song')]"));
        addToPlayList.click();
        Thread.sleep(2000);

        //WebElement songAdded =driver.findElement(By.xpath("//div[@class='alertify-logs top right']"));
        //Assert.assertTrue(songAdded.isDisplayed());

        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertTrue(notification.isDisplayed());
    }
}