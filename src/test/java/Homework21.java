import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework21  extends BaseTest {
    @Test
    public void renamePlaylist(){

    String newPlaylistName = "kristina.matskaylo2";
    LoginPage loginPage = new LoginPage(getDriver());
    HomePage homePage = new HomePage(getDriver());

    //loginPage.login();
    // homePage.doubleClickFirstPlaylist();
    //homePage.enterNewPLaylistName(newPlaylistName);
    //Assert.assertTrue(homePage.doesNewPlaylistexist(newPlaylistName));
        loginPage.provideEmail("kristina.matskaylo@testpro.io")
                 .providePassword("11111111*a")
                 .clickSubmitBtn();
        homePage.doubleClickFirstPlaylist()
                .enterNewPLaylistName(newPlaylistName);
        Assert.assertTrue(homePage.doesNewPlaylistexist(newPlaylistName));

    }
}


