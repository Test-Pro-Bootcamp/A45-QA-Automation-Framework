import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import POM.HomePage;
import POM.LoginPage;
public class HomeWork22 extends BaseTest{


    @Test
    public void renamePlaylist (){
        String playlistName = "New Play List";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
      //  homePage.doubleClickPlaylist();
      //  homePage.enterNewPlayListName(playlistName);
     //   Assert.assertTrue(homePage.doesPlaylistExist(playlistName));


    }

    @Test

    
    public void renamePlaylist1 (){
        String playlistName = "New Play List";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
       // homePage.doubleClickPlaylist();
       // homePage.enterNewPlayListName(playlistName);
       // Assert.assertTrue(homePage.doesPlaylistExist(playlistName));


    }
}