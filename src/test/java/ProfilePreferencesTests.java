import org.testng.annotations.Test;
import pom.LoginPage;
import pom.ProfilePreferences;


public class ProfilePreferencesTests extends BaseTest{
    @Test
    public void changeProfileName(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferences profilePreferences = new ProfilePreferences(getDriver());

String email = "demo@class.com";
String passwordField = "te$t$tudent";
String inputPassword = "te$t$tudent";

        loginPage.login();
        profilePreferences.openUserProfilePage();
        profilePreferences.provideTestEmail(email);
        profilePreferences.provideTestPassword(passwordField);
        profilePreferences.setCurrentPassword(inputPassword);
        profilePreferences.setNewName();
        profilePreferences.saveProfile();
        profilePreferences.newProfileName();
    }}