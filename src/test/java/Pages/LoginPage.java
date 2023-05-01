package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class LoginPage extends BasePage {
public LoginPage (WebDriver givenDriver){
    super(givenDriver);
}
   By emailField = By.cssSelector("input[type = 'email']");
    By passwordField = By.cssSelector("input[type = 'password']");
    By submitBtn = By.cssSelector("submit[type = 'submit']");

    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }
        public void clickSubmit () {

            findElement(submitBtn).click();
        }

        public void navigateToPage () {
            provideEmail("demo@class.com");
            providePassword("te$t$tudent");
            clickSubmit();

        }

    }