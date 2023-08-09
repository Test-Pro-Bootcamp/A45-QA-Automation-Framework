import org.testng.annotations.Test;
import pom.LoginPage;
import pom.ProfilePreferences;


public class ProfileTests extends BaseTest{
    @Test
    public void changeProfileName()throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferences profilePreferences = new ProfilePreferences(getDriver());

        String email = "demo@class.com";

        loginPage.login();
        profilePreferences.openUserProfilePage();
        profilePreferences.provideTestEmail(email);
        profilePreferences.provideTestPassword(password);
        profilePreferences.setCurrentPassword(password);
        profilePreferences.setNewName(newName);
        profilePreferences.saveProfile();
        profilePreferences.newProfileName();
    }}