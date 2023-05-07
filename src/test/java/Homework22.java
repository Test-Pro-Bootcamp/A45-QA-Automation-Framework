import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.pages.HomePage;
import pom.pages.LoginPage;

public class Homework22 extends BaseTest {
   @Test
   public void renamePlaylist() {
       String playlistName = "SNKim";

       LoginPage loginPage = new LoginPage(driver);
       HomePage homePage = new HomePage(driver);

       loginPage.login();
       homePage.contextClick();
       homePage.clickEditPlaylistButton();
       homePage.enterNewPlaylistName("SNKim");
       Assert.assertTrue(homePage.doesPlaylistExist("SNKim"));
   }
}
