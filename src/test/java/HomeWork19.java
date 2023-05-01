import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest{

    @Test
    public void deletePlayList() throws InterruptedException {
        String deletePlayList = "Delete playList";


        provideEmail("yuliia.tkachenko@testpro.io");
        providePassword("te$t$tudent");
        openPlayList();
        clickPlaylistButton();
        Assert.assertTrue(getDeletePlayList().contains(deletePlayList));

    }

        public void openPlayList(){
            WebElement emptyPlaylist = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
            emptyPlaylist.click();

        }

        public void clickPlaylistButton() throws InterruptedException{
            WebElement playButton = driver.findElement(By.cssSelector("button[class = \"del btn-delete-playlist\"]"));
            playButton.click();
            Thread.sleep(2000);
        }

        public String getDeletePlayList(){
            WebElement notification = driver.findElement(By.cssSelector("p[class=\"msg\"]"));
            return notification.getText();


        }


}
