import org.testng.Assert;
import org.testng.annotations.Test;
import pom.AllSongs;
import pom.HomePage;
import pom.LoginPage;
import pom.Playlists;

public class PlaylistTests extends BaseTest {

    @Test(enabled = true, priority = 1, description = "Create Playlist")
    public void createPlaylist() throws InterruptedException {
        String playlistName = "New Playlist";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongs allSongs = new AllSongs(driver);
        Playlists playlists = new Playlists(driver);
        loginPage.login();
        playlists.addNewPlaylist();
        playlists.enterNewPlaylistName(playlistName);
    }
    @Test(enabled = true, priority = 2, description = "Rename Playlist")
    public void renamePlaylist(){
        String playlistName = "Renamed Playlist";

        LoginPage loginPage = new LoginPage(driver);
        Playlists playlists = new Playlists(driver);

        loginPage.login();
        playlists.doubleClickPlaylist();
        playlists.enterNewPlaylistName(playlistName);
        Assert.assertTrue(playlists.doesPlaylistExist(playlistName));
    }
    @Test(enabled = true, priority = 3, description = "Add Song")
    public void addSongToPlaylist() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongs allSongs = new AllSongs(driver);
        Playlists playlists = new Playlists(driver);
        loginPage.login();
        homePage.viewAllSongs();
        allSongs.findFirstSong();
        allSongs.addToPlaylist();
        Assert.assertTrue(playlists.isSuccessDisplayed());
       // Assert.assertTrue(playlists.getSuccessMsg().contains("Added 1 song into"));
    }
    @Test(enabled = true, priority = 4, description = "Delete Playlist")
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

        //searchSong();
//        WebElement viewAll = driver.findElement(By.cssSelector("section.songs h1 button"));
//        viewAll.click();
//        Thread.sleep(1000);
        //viewSongs();
//        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//table[@class='items']/tr[1]/td[2]"));
//        firstSong.click();
//        Thread.sleep(1000);
       // findFirstSong();
//        WebElement addTo = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[2]"));
//        addTo.click();
//        Thread.sleep(1000);
        //addSong();
//        WebElement playList = driver.findElement(By.xpath("//section[@id='songsWrapper']//li[7]"));
//        playList.click();
//        Thread.sleep(2000);
      //  playlist17();
//        WebElement verification = driver.findElement(By.xpath("//div[@class='success show']"));
//        Thread.sleep(2000);
//        Assert.assertEquals(verification.getText(), "Added 1 song into \"homework17.\"");
   //     success();

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