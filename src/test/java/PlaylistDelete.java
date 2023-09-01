import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.AllSongs;
import pom.HomePage;
import pom.LoginPage;
import pom.Playlists;

public class PlaylistDelete extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Playlists playlists = new Playlists(driver);



        loginPage.login();
        playlists.selectPlaylist();
        playlists.deletePlaylist();
      //  playlists.getSuccessMsg();
        Assert.assertTrue(playlists.isSuccessDisplayed());
    }
}
 //       Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));
//    String deletedPlaylistMsg = "Deleted playlist";
//    public String getDeletedPlaylistMsg(){
//        WebElement deletePlaylistMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
//        //  driver.findElement(By.xpath("//div[@class='success show']"));
//        return deletePlaylistMsg.getText();


//        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[5]")));
//        //driver.findElement(By.xpath("//section[@id='playlists']//li[5]"));
//        playlist.click();
//        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='del btn-delete-playlist']")));
//        //  driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
//        deletePlaylist.click();
//        // Thread.sleep(2000);
//        Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));

//    @Test
//    public void deletePlaylist()  {
//        String deletedPlaylistMsg = "Deleted playlist";
//
//        provideEmail();
//        providePassword();
//        logInButton();
//
//        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[5]")));
//        //driver.findElement(By.xpath("//section[@id='playlists']//li[5]"));
//        playlist.click();
//        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='del btn-delete-playlist']")));
//        //  driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
//        deletePlaylist.click();
//        // Thread.sleep(2000);
//        Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));
//    }
//    public String getDeletedPlaylistMsg(){
//        WebElement deletePlaylistMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
//        //  driver.findElement(By.xpath("//div[@class='success show']"));
//        return deletePlaylistMsg.getText();
//
//    }
//}