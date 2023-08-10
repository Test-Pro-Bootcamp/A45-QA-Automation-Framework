import org.testng.annotations.Test;
import pom.LoginPage;
import pom.ProfilePreferences;


public class ProfileTests extends BaseTest{
    @Test
    public void changeProfileName()throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferences profilePreferences = new ProfilePreferences(getDriver());


        loginPage.login();
        profilePreferences.openUserProfilePage();
        profilePreferences.provideTestEmail();
        profilePreferences.provideTestPassword();
        profilePreferences.setCurrentPassword();
        profilePreferences.setNewName();
        profilePreferences.saveProfile();
        profilePreferences.newProfileName();
    }}