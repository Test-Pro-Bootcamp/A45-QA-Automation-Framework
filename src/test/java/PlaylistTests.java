import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.HomePage;
import pageFactory.LoginPage;

import static org.testng.Assert.assertTrue;

public class PlaylistTests extends BaseTest {

    @Test
    public void createAnewPlaylistTest(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideValidLogin();
        homePage.createAnewPlaylist()
                .chooseDropMenuNewPlaylistOption()
                .enterPlaylistName();
        homePage.getNotificationText();
    }
    @Test
    public void playFirstSongInAllSongsPlaylist() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideValidLogin();
        homePage.clickAllSongs().selectFirstSongInAllSongs().playFirstSongInAllSongs();
        homePage.validateTheSoundBar();
    }
    @Test
    public void addSongToNewPlaylist() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideValidLogin();
        homePage.clickAllSongs().selectFirstSongInAllSongs().addToPlaylist().enterPlaylistNameInDropMenu();
        homePage.getNotificationText();
    }
    @Test
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        loginPage.provideEmail("svyeta@test.com").providePassword("te$t$tudent").clickSubmitButton();
        homePage.doubleClickFirstPlaylist().enterNewPlaylistName("SNKim");
        homePage.retrievePlaylistName();
    }
    @Test
    public void deletePlaylistTest(){

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideValidLogin();
        homePage.chooseFirstPlaylist();
        homePage.deletePlaylistButton().clickOkToDeletePlaylist();
        homePage.getNotificationText();
    }
}
