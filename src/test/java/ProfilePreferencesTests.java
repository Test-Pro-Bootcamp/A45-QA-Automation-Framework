import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.ProfilePreferences;

import java.util.UUID;


public class ProfilePreferencesTests extends BaseTest{

    @Test
    public void changeProfileName(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferences profilePreferences = new ProfilePreferences(getDriver());

        String newName = profilePreferences.getRandomString();

        loginPage.login();
        profilePreferences.openUserProfilePage();
        profilePreferences.provideTestEmail("demo@class.com");
        profilePreferences.provideTestPassword("te$t$tudent");
        profilePreferences.setCurrentPassword("te$t$tudent");
        profilePreferences.setNewName(newName);
        profilePreferences.saveProfile();
        profilePreferences.getNewProfileName();
        Assert.assertEquals(newName,
                profilePreferences.getNewProfileName());
    }
}