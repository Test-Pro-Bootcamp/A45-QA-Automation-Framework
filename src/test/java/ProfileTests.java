import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class ProfileTests extends BaseTest {

    @Test
    public void changeProfileNameTest () throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

       //Login
        loginPage.login();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        Thread.sleep(1000);
        avatarIcon.click();

        String randomName = generateRandomName();
        System.out.println("randomName--: " + randomName);

        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();
        Thread.sleep(2000);

        WebElement actualProfileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.view-profile>span")));
        System.out.println("actualProfileName: " + actualProfileName.getText());
//        Custom assertion message
        Assert.assertEquals(actualProfileName.getText(), randomName, "Profile name mismatch");
    }
}
