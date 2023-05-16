import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.HomePage;
import pageFactory.LoginPage;

public class PlaylistTests extends BaseTest {

    @Test
    public void deletePlaylistTest(){

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideValidLogin();
        homePage.chooseFirstPlaylist();
        homePage.deletePlaylistButton();

        Assert.assertTrue(homePage.notificationElement.isDisplayed());
    }
}
