/*import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;*/
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import Pages.LoginPage;
import Pages.HomePage;


public class HomeWorkTest22 extends BaseTest{

 @Test
    public void renamePlaylist(){
        String playlistName="Test pro Edited Playlist";
        LoginPage loginPage=new LoginPage(driver);
        HomePage homePage=new HomePage(driver);

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(playlistName);
        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));

    }




}
