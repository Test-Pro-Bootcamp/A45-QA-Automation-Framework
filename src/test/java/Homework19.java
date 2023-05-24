import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist () throws InterruptedException {

        provideEmail("anton.prymak@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        WebElement selectPlayList = driver.findElement(By.xpath("//li[@class = 'playlist playlist']"));
        selectPlayList.click();
        Thread.sleep(200);

        WebElement deletePlaylistButton = driver.findElement(By.xpath("//button[@class ='del btn-delete-playlist']"));
        deletePlaylistButton.click();
        Thread.sleep(200);

        WebElement confirmationMessage = driver.findElement(By.xpath("//div[@class='success show']"));
        Assert.assertTrue(confirmationMessage.isDisplayed());


    }

}
