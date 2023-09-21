import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.ProfilePreferences;

import java.util.UUID;


public class ProfilePreferencesTests extends BaseTest{

    @Test
    public void changeProfileName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProfilePreferences profilePreferences = new ProfilePreferences(driver);

        String newName = profilePreferences.getRandomString();

        loginPage.login();
//        Thread.sleep(3000);
        profilePreferences.openUserProfilePage();
        profilePreferences.setCurrentPassword("Proverbs99!");
        profilePreferences.setNewName(newName);
        profilePreferences.provideTestEmail("esther.martinez32@gmail.com");
    //    profilePreferences.provideTestPassword("te$t$tudent");


        profilePreferences.saveProfile();
        profilePreferences.getNewProfileName();
        Assert.assertEquals(newName, profilePreferences.getNewProfileName());
    }
}