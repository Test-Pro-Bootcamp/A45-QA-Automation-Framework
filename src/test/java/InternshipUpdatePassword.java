import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        Thread.sleep(3000);
        internshipProfilePreferences.openUserProfilePage();
        internshipProfilePreferences.provideCurrentPassword("Proverbs99!");
        internshipProfilePreferences.setNewPassword("IwillSing99!");
        internshipProfilePreferences.saveProfile();
        Thread.sleep(3000);
        //Verify password updated
        //these are not correct
        //Assert.assertTrue(internshipProfilePreferences.profileUpdateSuccess().equals("Profile updated"));//
        //Assert.assertEquals(internshipProfilePreferences.profileUpdateSuccess(),"Profile updated");
        //Assert.assertEquals("Profile updated", internshipProfilePreferences.profileUpdatedSuccess.getText());
        //String success = "Profile updated";
        //Assert.assertEquals(internshipProfilePreferences.profileUpdatedSuccess.getText, success);
        WebElement popup = driver.findElement(By.cssSelector("div[class='success show']"));
        String success = "Profile updated.";
        String getText = popup.getText();
        Assert.assertEquals(getText, success);


//        @Test
//        public void testAssertFunctions() {
//            System.setProperty("webdriver.chrome.driver", "C:\\I2EWebsiteTest\\Driver\\chromedriver.exe");
//            WebDriver driver = new ChromeDriver();
//            driver.navigate().to("https://www.browserstack.com/");
//            String ActualTitle = driver.getTitle();
//            String ExpectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
//            Assert.assertEquals(ExpectedTitle, ActualTitle);
//        //***Also assert that new password is saved in database in encrypted format***
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
        //***figure out how to use the data provider to pom page (also move from basetest) instead of hard coding***
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


