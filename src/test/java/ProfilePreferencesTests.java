import org.testng.annotations.Test;
import pom.LoginPage;
import pom.ProfilePreferences;


public class ProfilePreferencesTests extends BaseTest{
    @Test
    public void changeProfileName(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferences profilePreferences = new ProfilePreferences(getDriver());


        loginPage.login();
        profilePreferences.openUserProfilePage();
        profilePreferences.provideTestEmail("demo@class.com");
        profilePreferences.provideTestPassword("te$t$tudent");
        profilePreferences.setCurrentPassword("te$t$tudent");
        profilePreferences.setNewName();
        profilePreferences.saveProfile();
        profilePreferences.newProfileName();
    }}