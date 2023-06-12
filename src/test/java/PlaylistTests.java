import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.SearchPage;
public class PlaylistTests extends BaseTest{
    @Test(priority = 1)
    public void addSongToPlaylist() {
        String expectedNotificationText = "Added 1 song into";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());

        loginPage.provideEmail("kristina.matskaylo@testpro.io")
                .providePassword("11111111*a")
                .clickSubmitBtn();

        searchPage.searchSong("Beautiful")
                .clickViewAllButton()
                .selectFirstSongFromSearchResult()
                .clickAddToButton()
                .choosePlaylistToAdd();

        Assert.assertTrue(homePage.actualNotificationText().contains(expectedNotificationText));
    }
    @Test(priority = 2)
    public void renamePlaylist(){
        String newPlaylistName = "kristina.matskaylo2";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("kristina.matskaylo@testpro.io")
                .providePassword("11111111*a")
                .clickSubmitBtn();

        homePage.doubleClickFirstPlaylist()
                .enterNewPLaylistName(newPlaylistName);

        Assert.assertTrue(homePage.doesNewPlaylistexist(newPlaylistName));
    }
    @Test (priority = 3)
    public void deletePlaylist() {
        String expectedNotificationText = "Deleted playlist \"kristina.matskaylo.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("kristina.matskaylo@testpro.io")
                .providePassword("11111111*a")
                .clickSubmitBtn();
        homePage.navigateToFirstPlaylist()
                .clickRedBtnPlaylist();
        Assert.assertTrue(homePage.actualNotificationText().contains(expectedNotificationText));
    }
}
