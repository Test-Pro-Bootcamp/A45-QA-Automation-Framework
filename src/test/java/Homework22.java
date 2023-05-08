import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

@Test
public class Homework22 extends BaseTest {

    public void renamePlaylist() {
        //GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);
        loginPage.login();
        homePage.getUserAvatar();
        //WHEN
        basePage.doubleClick(By.cssSelector(".playlist:nth-child(3)"));
        basePage.findElement(By.cssSelector("input[name='name']"));
        WebElement inputPlaylistNameField = driver.findElement(By.cssSelector("input[name='name']"));
        basePage.doubleClick(By.cssSelector("input[name='name']"));
        inputPlaylistNameField.sendKeys("Homework21");
        inputPlaylistNameField.sendKeys(Keys.ENTER);
        //THEN
        basePage.findElement(By.cssSelector(".success.show"));
        WebElement successMessage = driver.findElement(By.cssSelector(".success.show"));
        Assert.assertEquals(successMessage.getText(), "Updated playlist \"Homework21.\"");
    }
}