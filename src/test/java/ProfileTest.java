import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.ProfilePreferences;


public class ProfileTest extends BaseTest{
    @Test
    public void changeProfileName()throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferences profilePreferences = new ProfilePreferences(getDriver());

        loginPage.login();
        profilePreferences.openUserProfilePage();
        profilePreferences.provideTestEmail(email);
        profilePreferences.provideTestPassword(password);
        profilePreferences.setCurrentPassword(password);
        profilePreferences.setNewName(newName);
        profilePreferences.saveProfile();


//        WebElement newProfileName = driver.findElement(By.xpath("//span[@class='name']"));
//        Thread.sleep(2000);
//        Assert.assertEquals(newProfileName.getText(), newName);
//    }
//}
    }}