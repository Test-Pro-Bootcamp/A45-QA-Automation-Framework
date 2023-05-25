import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest{

    @Test
    public void testMethod() throws InterruptedException {
        String playlistName = "kz-new playlist";


        provideEmail("pdr.deepthi@gmail.com");
        providePassword("te$t$tudent1");
        clickSubmit();
       Thread.sleep(2000);

       WebElement search = driver.findElement(By.cssSelector("[type='search']"));
       search.sendKeys("pluto");
        Thread.sleep(2000);

      WebElement viewAll = driver.findElement(By.cssSelector("div.results h1 > button"));
       viewAll.click();
        Thread.sleep(2000);

        WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper td.title"));
       firstSong.click();
       Thread.sleep(2000);


     WebElement addToButton = driver.findElement(By.cssSelector("section#songResultsWrapper button[class='btn-add-to']"));
     addToButton.click();
     Thread.sleep(2000);

//     WebElement addNewPlaylist = driver.findElement(By.cssSelector("section#songResultsWrapper input[type='text']"));
//     addNewPlaylist.sendKeys("kz-new playlist");
//
//     WebElement newPlaylistButton = driver.findElement(By.cssSelector("section#songResultsWrapper button[type='submit']"));
//      newPlaylistButton.click();

     WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'kz-new playlist')]"));
     playlist.click();
     Thread.sleep(2000);

     WebElement notif = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertEquals(notif.getText(),"Added 1 song into \"" + playlistName + ".\"");


    }
}
