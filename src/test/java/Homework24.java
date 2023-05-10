import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.HomePage;
import pageFactory.LoginPage;

public class Homework24 extends BaseTest{
    @Test
    public void renamePlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("svyeta@test.com").providePassword("te$t$tudent").clickSubmitButton();
        homePage.doubleClickFirstPlaylist().enterNewPlaylistName("SNKim");
        Assert.assertEquals(homePage.retrievePlaylistName(),"SNKim");
    }
}
