import org.testng.Assert;
import org.testng.annotations.Test;
import pom.InternshipHomePage;
import pom.InternshipLoginPage;
import pom.InternshipProfilePreferences;

public class InternshipUpdatePassword extends BaseTest {

    @Test
    public void updatePassword() throws InterruptedException {
        InternshipLoginPage internshipLoginPage = new InternshipLoginPage(driver);
        InternshipProfilePreferences internshipProfilePreferences = new InternshipProfilePreferences(driver);
        InternshipHomePage internshipHomePage = new InternshipHomePage(driver);

        //Update password
        internshipLoginPage.loginInitialPassword();
        internshipProfilePreferences.openUserProfilePage();
        internshipProfilePreferences.provideCurrentPassword("Proverbs99!");
        internshipProfilePreferences.setNewPassword("IwillSing99!");
        internshipProfilePreferences.saveProfile();
        //Verify password updated
        Assert.assertTrue(internshipProfilePreferences.profileUpdateSuccess().equals("Profile updated"));

//        //***Also assert that new password is saved in database***
//
//        //Logout
//        internshipHomePage.logout();
//        //verify logged out
//        Assert.assertTrue(internshipLoginPage.submitBtn().isDisplayed());
//
//        //Login with newly saved password
//        internshipLoginPage.loginNewPassword();
//        //verify logged in
//        Assert.assertTrue(internshipHomePage.assertAvatar().isDisplayed());
//
//        //Login with old password
//        internshipLoginPage.loginInitialPassword();
//        //Verify not logged in
//        Assert.assertTrue(internshipLoginPage.submitBtn().isDisplayed());
//
//        //Clean up - Change password to former password so that test will work again as coded
//        internshipLoginPage.loginNewPassword();
//        internshipProfilePreferences.openUserProfilePage();
//        internshipProfilePreferences.provideCurrentPassword("IwillSing99!");
//        internshipProfilePreferences.setNewPassword("Proverbs99!");
//        internshipProfilePreferences.saveProfile();
//        //Verify password updated
//        Assert.assertTrue(internshipProfilePreferences.profileUpdateSuccess().equals("Profile updated"));
//
    }
}



//    @Test (dataProvider = "IncorrectData", dataProviderClass = BaseTest.class)
//    public void loginIncorrectData(String email, String incorrectPassword) throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.provideEmail(email);
//        loginPage.providePassword(incorrectPassword);
//        loginPage.clickSubmit();
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//    }


