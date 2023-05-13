import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class Homework25 extends BaseTest {
//    @Test
//    public void renamePlaylist(){
//        String playlistName = "Daria45";
//
//        LoginPage loginPage = new LoginPage(getDriver());
//        HomePage homePage = new HomePage(getDriver());
//
//        loginPage.provideEmail("daria.pavlyuk@testpro.io")
//                 .providePassword("te$t$tudent")
//                 .clickSubmitBtn();
//
//        homePage.doubleClickPlaylist();
//           homePage.enterNewPlaylistName(playlistName);
//        Assert.assertEquals(homePage.getPlaylistName(), playlistName);
//        //compares the retrieved playlist from koel to the String playlidsstName
//
//    }
@Test
public void LoginValidEmailPasswordTest ()   {

    LoginPage loginPage = new LoginPage(getDriver());
    HomePage homePage = new HomePage(getDriver());

    loginPage.provideEmail("daria.pavlyuk@testpro.io")
            .providePassword("te$t$tudent")
            .clickSubmitBtn();

    Assert.assertTrue(homePage.isAvatarDisplayed());
}

}
