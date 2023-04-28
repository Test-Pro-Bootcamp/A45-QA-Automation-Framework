import  org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.Assert;

public class HomeWorkDeleteplayTest19 extends BaseTest19{
     @Test (dataProvider = "IncorrectLoginData", dataProviderClass = BaseTest19.class, enabled = true, priority = 0, description = "Deleting song from playlist")
    public void deletedPlaylist(String email,String password) throws InterruptedException {
         navigateToPage();
         provideEmail(email);
         providePassword(password);
         clickSubmit();
         Thread.sleep(1000);
         WebElement allSong = driver.findElement(By.xpath("//a[normalize-space()='All Songs']"));
         allSong.click();
         WebElement selectSong = driver.findElement(By.xpath("//div[@class='song-list-wrap main-scroll-wrap all-songs']//thread"));
         selectSong.click();
         WebElement pressAllButton = driver.findElement(By.xpath("//button[@id='extraTabAlbum']"));
         WebElement deletButton = driver.findElement(By.xpath("//button[normalize-space()='Clear']"));
         deletButton.click();
         WebElement queueButton = driver.findElement(By.xpath("//a[normalize-space()='Current Queue']"));
         queueButton.click();
         WebElement readText = driver.findElement(By.xpath("//section[@id='queueWrapper']//div[@class='screen-placeholder']//div//div[@class='text']"));
         readText.click();
         Assert.assertEquals(readText.getText(), "No song queued");




    }



}
