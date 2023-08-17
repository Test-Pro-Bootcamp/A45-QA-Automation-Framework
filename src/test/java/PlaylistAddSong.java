import org.testng.annotations.Test;
import pom.AllSongs;
import pom.HomePage;
import pom.LoginPage;
import pom.Playlists;

public class PlaylistAddSong extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongs allSongs = new AllSongs(driver);
        Playlists playlists = new Playlists(driver);
        loginPage.login();
        //homePage.searchSong();
        homePage.viewAllSongs();
        allSongs.findFirstSong();



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
//        WebElement playList = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[7]"));
//        playList.click();
//        Thread.sleep(2000);
        playlist17();
//        WebElement verification = driver.findElement(By.xpath("//div[@class='success show']"));
//        Thread.sleep(2000);
//        Assert.assertEquals(verification.getText(), "Added 1 song into \"homework17.\"");
        success();
//  //after method in baseTest
//        driver.quit();
    }
}
