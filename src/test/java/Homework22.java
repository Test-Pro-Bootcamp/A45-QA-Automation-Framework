import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class Homework22 extends BaseTest {
    //String playlistName = "Daria45";

    @Test
    public void renamePlaylist() {
        String playlistName = "Daria45" ;
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        homePage.doubleClickFirstPlaylist();
        homePage.enterPlaylistName(playlistName);


        Assert.assertEquals(playlistName,getPlaylistName());
    }

    //public String getPlaylistName() {
        //WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        //WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + playlistName + "']")));
        //return playlistElement.getText();

    }



//Assert.assertTrue(homePage.doesPlaylistExist(playlistName));

//public String getPlaylistName() {
   // WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+newPlaylistName+"']")));
        //WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3"));

    //return playlistElement.getText();



