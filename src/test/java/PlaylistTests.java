import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

import java.util.List;

public class PlaylistTests extends BaseTest {

    String newPlaylistName = "Daria45";

    @Test
    public void renamePlaylist() {
String playlistName ="Daria45";
LoginPage loginPage = new LoginPage(driver);

        //LoginPage loginPage = new LoginPage(getDriver());
        //HomePage homePage = new HomePage(getDriver());
        //loginPage.provideEmail("daria.pavlyuk@testpro.io")
                //.providePassword("te$t$tudent")
                //.clickSubmitBtn();

        //homePage.doubleClickPlaylist();
        //homePage.enterNewPlaylistName(newPlaylistName);
        //Assert.assertEquals(homePage.getPlaylistName(), newPlaylistName);
    }

    @Test
    public void doesPlaylistExist() {
        String playlistName = "Daria45";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("daria.pavlyuk@testpro.io")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();

        Assert.assertEquals(homePage.getPlaylistName(), playlistName);


    }
    @Test
        public void chooseAllSongsList() {
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);

            loginPage.provideEmail("daria.pavlyuk@testpro.io")
                    .providePassword("te$t$tudent")
                    .clickSubmitBtn();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs")));
            driver.findElement(By.cssSelector("li a.songs")).click();
        }

        }









