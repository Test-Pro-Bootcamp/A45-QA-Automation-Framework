package POM;

import POM.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    By registrationLink = By.cssSelector("#hel");

    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        findElement(submitBtn).click();
    }

    public void login() {
        provideEmail("pdr.deepthi@gmail.com");
        providePassword("te$t$tudent1");
        clickSubmit();
    }

    public boolean isRegistrationLinkDisplayed(){
      return findElement(registrationLink).isDisplayed();
    }

}


