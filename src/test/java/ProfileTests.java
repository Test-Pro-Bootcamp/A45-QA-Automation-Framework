import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class ProfileTests extends BaseTest {

    @Test
    public static void changeProfileNameTest () throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        clickAvatarIcon();
        String randomName = generateRandomName();
        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();
        WebElement actualProfileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.view-profile>span")));
        Assert.assertEquals(actualProfileName.getText(), randomName);
    }
}
