import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.InternshipHomePage;
import pom.InternshipLoginPage;
import pom.InternshipProfilePreferences;

public class InternshipUpdatePassword extends BaseTest {

    @Test (enabled = true, priority = 1, description = "update password")
    public void updatePassword() {
        InternshipLoginPage internshipLoginPage = new InternshipLoginPage(driver);
        InternshipProfilePreferences internshipProfilePreferences = new InternshipProfilePreferences(driver);
        InternshipHomePage internshipHomePage = new InternshipHomePage(driver);

        internshipLoginPage.loginInitialPassword();
        Assert.assertTrue(internshipHomePage.assertAvatar().isDisplayed());

        internshipProfilePreferences.openUserProfilePage();
        internshipProfilePreferences.provideCurrentPassword("Proverbs99!");
        internshipProfilePreferences.setNewPassword("IwillSing99!");
        internshipProfilePreferences.saveProfile();
        //Verify password updated
//        WebElement popup = driver.findElement(By.cssSelector("div[class='success show']"));
//        wait.until(ExpectedConditions.elementToBeClickable(popup));
//        String success = "Profile updated.";
//        String getText = popup.getText();
//        Assert.assertEquals(getText, success);
        String expectedSuccessMessage = "Profile updated.";
        //***calling the object of InternshipProfilePreferences (lower case i) instead of the class
        Assert.assertEquals(internshipProfilePreferences.getPopUpSuccessMessage(), expectedSuccessMessage);
//        ***Also assert that new password is saved in database in encrypted format***
    }
    @Test (enabled = true, priority = 2, description = "login with updated password")
    void loginWithUpdatedPassword() throws InterruptedException{
        InternshipLoginPage internshipLoginPage = new InternshipLoginPage(driver);
        InternshipProfilePreferences internshipProfilePreferences = new InternshipProfilePreferences(driver);
        InternshipHomePage internshipHomePage = new InternshipHomePage(driver);

        internshipLoginPage.loginNewPassword();
        //Thread.sleep(3000);
        Assert.assertTrue(internshipHomePage.assertAvatar().isDisplayed());
        }
   @Test (enabled = true, priority = 3, description = "login old password")
   void loginWithOldPassword(){
       InternshipLoginPage internshipLoginPage = new InternshipLoginPage(driver);
       InternshipProfilePreferences internshipProfilePreferences = new InternshipProfilePreferences(driver);
       InternshipHomePage internshipHomePage = new InternshipHomePage(driver);

       internshipLoginPage.loginInitialPassword();
       Assert.assertTrue(internshipLoginPage.submitBtn().isDisplayed());
   }
   @Test (enabled = true, priority = 4, description = "change back to initial password")
   void changeBackToInitialPassword(){
       InternshipLoginPage internshipLoginPage = new InternshipLoginPage(driver);
       InternshipProfilePreferences internshipProfilePreferences = new InternshipProfilePreferences(driver);
       InternshipHomePage internshipHomePage = new InternshipHomePage(driver);

       internshipLoginPage.loginNewPassword();
       internshipProfilePreferences.openUserProfilePage();
       internshipProfilePreferences.provideCurrentPassword("IwillSing99!");
       internshipProfilePreferences.setNewPassword("Proverbs99!");
       internshipProfilePreferences.saveProfile();
       //String expectedSuccessMessage = "Profile updated.";
       Assert.assertTrue(internshipProfilePreferences.getPopUpSuccessMessage().equals("Profile updated."));
      // Assert.assertEquals(internshipProfilePreferences.getPopUpSuccessMessage(), expectedSuccessMessage);
   }

        //***figure out how to use the data provider to pom page (also move from basetest) instead of hard coding***

//to figure out how to use a string later
//        String newName = profilePreferences.getRandomString();
//
//        loginPage.login();
////        Thread.sleep(3000);
//        profilePreferences.openUserProfilePage();
//        profilePreferences.setCurrentPassword("Proverbs99!");
//        profilePreferences.setNewName(newName);
//        profilePreferences.provideTestEmail("esther.martinez32@gmail.com");
//        //    profilePreferences.provideTestPassword("te$t$tudent");
//
//
//        profilePreferences.saveProfile();
//        profilePreferences.getNewProfileName();
//        Assert.assertEquals(newName, profilePreferences.getNewProfileName());



}


