package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


    public class LoginPage extends BasePage {
        private @FindBy(css = "input[type='email']")
        WebElement emailField;

        private @FindBy(css = "input[type='password']")
        WebElement passwordField;

        private @FindBy(css = "button[type='submit']")
        WebElement loginButton;

        public LoginPage(WebDriver givenDriver) {
            super(givenDriver);
        }

        public LoginPage provideEmail(String email){
            findElement(emailField).sendKeys(email);
            return this;
        }
        public LoginPage providePassword(String password){
            findElement(passwordField).sendKeys(password);
            return this;
        }
        public LoginPage clickSubmitButton(){
            findElement(loginButton).click();
            return this;
        }
        public void login(){
            provideEmail("svyeta@test.com");
            providePassword("te$t$tudent");
            clickSubmitButton();
        }
    }


