import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class Homework23 extends BaseTest {
    @Test
    public void renamePlaylist(){
        String playlistName = "Daria45";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo@class.com")
                 .providePassword("te$t$tudent")
                 .clickSubmitBtn();

        homePage.doubleClickPlaylist()
                .enterNewPlaylistName(playlistName);
//
        Assert.assertEquals(homePage.getPlaylistName(), playlistName);
        //compares the retrieved playlist from koel to the String playlidsstName

    }
}
