import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.HomePage;
import pageFactory.LoginPage;

public class Homework23 extends BaseTest{
    @Test
    public void renamePlaylist(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        loginPage.provideEmail("svyeta@test.com").providePassword("te$t$tudent").clickSubmitButton();
        homePage.doubleClickFirstPlaylist().enterNewPlaylistName("SNKim");
        Assert.assertEquals(homePage.retrievePlaylistName(),"SNKim");

    }
}
