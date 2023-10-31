import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        //InternshipHomePage internshipHomePage = new InternshipHomePage(driver);
        //Update password
        internshipLoginPage.loginInitialPassword();

        internshipProfilePreferences.openUserProfilePage();
        internshipProfilePreferences.provideCurrentPassword("Proverbs99!");
        internshipProfilePreferences.setNewPassword("IwillSing99!");
        internshipProfilePreferences.saveProfile();
        //Verify password updated
//THIS WON'T WORK WITHOUT A WAIT
        Thread.sleep(3000);
//        WebElement popup = driver.findElement(By.cssSelector("div[class='success show']"));
//        wait.until(ExpectedConditions.elementToBeClickable(popup));
//        String success = "Profile updated.";
//        String getText = popup.getText();
//        Assert.assertEquals(getText, success);
        String expectedSuccessMessage = "Profile updated.";
        Assert.assertEquals(InternshipProfilePreferences.getPopUpSuccessMessage(), expectedSuccessMessage);

        //***Also assert that new password is saved in database in encrypted format***
        //Logout

//        Thread.sleep(3000);
//        internshipHomePage.logout();
//        //verify logged out
//        Assert.assertTrue(internshipLoginPage.submitBtn().isDisplayed());
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
        //***figure out how to use the data provider to pom page (also move from basetest) instead of hard coding***





}}


