import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework23 extends BaseTest{
    @Test
    public void renamePlaylist(){
        String newPlName = "AlekseiZZZ";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        homePage.doubleClickFirstPlaylist()
                .enterNewPlaylistName(newPlName);
        Assert.assertTrue(homePage.doesPlaylistExists(newPlName));
    }

}
