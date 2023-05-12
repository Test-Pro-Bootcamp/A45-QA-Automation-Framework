import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest{
    @Test

    public void deletePlaylist () throws InterruptedException {

        provideEmail("pavel.furnic@testpro.io");
        providePassword("Test123456789@");
        clickSubmit();

        WebElement selectPlayList = driver.findElement(By.xpath("//li[@class = 'playlist playlist']"));
        selectPlayList.click();
        Thread.sleep(200);

        WebElement deletePlaylistButton = driver.findElement(By.xpath("//button[@class ='del btn-delete-playlist']"));
        deletePlaylistButton.click();
        Thread.sleep(200);

        // If there is songs enable
//        WebElement confirmDeletingPlaylist = driver.findElement(By.xpath("//button[@class ='ok']"));
//        confirmDeletingPlaylist.click();

        WebElement confirmMessage = driver.findElement(By.xpath("//div[@class='success show']"));
        Assert.assertTrue(confirmMessage.isDisplayed());


    }

}


