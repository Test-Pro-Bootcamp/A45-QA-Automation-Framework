import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String playlistName = "Tony1";

        navigateToPage();
        provideEmail("anton.prymak@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
        search.sendKeys("Reactor");

        WebElement viewAll = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.results h1 > button")) );
        viewAll.click();

        WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper td.title")));
        firstSong.click();

        WebElement addToButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-add-to")));
        addToButton.click();

        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'" + playlistName + "')]")));
        playlist.click();

        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertEquals(notification.getText(), "Added 1 song into \"" + playlistName + ".\"");

        System.out.println("Check the result: " + playlist);

//        Thread.sleep(2000);
//
//        WebElement search = driver.findElement(By.cssSelector("[type='search']"));
//        search.sendKeys("Reactor");
//        Thread.sleep(2000);
//
//        WebElement viewAll = driver.findElement(By.cssSelector("div.results h1 > button"));
//        viewAll.click();
//        Thread.sleep(2000);
//
//        WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper td.title"));
//        firstSong.click();
//
//        WebElement addToButton = driver.findElement(By.cssSelector(".btn-add-to"));
//        addToButton.click();
//        Thread.sleep(2000);
//
//        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'" + playlistName + "')]"));
//        playlist.click();
//
//        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
//        Assert.assertEquals(notification.getText(), "Added 1 song into \"" + playlistName + ".\"");
//
//        System.out.println("Check the result:" + playlist);
    }
}
