import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework24 extends BaseTest{
    @Test
    public void renamePlaylist(){
        String newPlName = "AlekseiZZZ";
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();
        HomePage homePage = new HomePage(getDriver());
        homePage.doubleClickFirstPlaylist()
                .enterNewPlaylistName(newPlName);
        Assert.assertTrue(homePage.doesPlaylistExists(newPlName));
    }

}
