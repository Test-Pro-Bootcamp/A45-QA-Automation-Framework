package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;
import java.net.URL;
import static java.sql.DriverManager.getDriver;


public class LoginPage extends BasePage {

        private @FindBy(xpath = "//*[@id='app']/div/form/div/img")
        WebElement birdLogo;
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
        public LoginPage provideValidLogin(){
            provideEmail("demo@class.com");
            providePassword("te$t$tudent");
            clickSubmitButton();
            return this;
        }
        public boolean getBirdLogo() {
            return findElement(birdLogo).isDisplayed();
        }
}


