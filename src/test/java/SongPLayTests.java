import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
public class SongPLayTests extends  BaseTest {
    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("kristina.matskaylo@testpro.io")
                .providePassword("11111111*a")
                .clickSubmitBtn();
        homePage.clickPlayNextSongButton()
                .clickPlayButton();

        Assert.assertTrue(homePage.songPlaying());
    }
}
 