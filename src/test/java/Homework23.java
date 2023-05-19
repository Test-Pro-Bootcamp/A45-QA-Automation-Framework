import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework23 extends BaseTest{
    @Test
    public void renamePlaylist (){

        LoginPage loginpage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginpage.provideEmail("amanda.martins@testpro.io").providePassword("te$t$tudent").clickSubmit();
        homePage.rightClickFirstPlaylist().clickEdit().enterPlaylistName();
    }
}
