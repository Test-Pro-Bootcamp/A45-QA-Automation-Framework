import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class HomeWork20 extends BaseTest{

        @Test

        public void deletePlaylist () throws InterruptedException {

            provideEmail("pavel.furnic@testpro.io");
            providePassword("Test123456789@");
            clickSubmit();

            WebElement selectPlayList = driver.findElement(By.xpath("//li[@class = 'playlist playlist']"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class = 'playlist playlist']"))).click();
            //selectPlayList.click();


            WebElement deletePlaylistButton = driver.findElement(By.xpath("//button[@class ='del btn-delete-playlist']"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class ='del btn-delete-playlist']"))).click();
            //deletePlaylistButton.click();



            // If there is songs enable
//        WebElement confirmDeletingPlaylist = driver.findElement(By.xpath("//button[@class ='ok']"));
//        confirmDeletingPlaylist.click();

            WebElement confirmMessage = driver.findElement(By.xpath("//div[@class='success show']"));
            Assert.assertTrue(confirmMessage.isDisplayed());
}
}
