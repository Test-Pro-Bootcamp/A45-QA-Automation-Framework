import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class PlaylistTest extends BaseTest {
    @Test
        public void renamePlaylist() {
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);

            loginPage.provideEmail("demo@class.com");
            loginPage.providePassword("te$t$tudent");
            loginPage.clickSubmit();

            Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        }

    @Test
    public static void deletePlaylist() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

//        Login
        loginPage.login();
        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        LoginPage.clickSubmit();

//        Perform playlist deletion
        homePage.openPlaylist();
        homePage.deletePlaylist();
    }



}