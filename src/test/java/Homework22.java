import com.github.dockerjava.api.model.Driver;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework22 extends BaseTest{
    @Test
    public void renamePlaylist (){

        LoginPage loginpage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginpage.login();
        homePage.rightClickFirstPlaylist();
        homePage.clickEdit();
        homePage.enterPlaylistName();
        homePage.assertPlaylistExist();
    }
}
