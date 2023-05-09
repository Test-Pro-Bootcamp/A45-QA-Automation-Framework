package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "input[type='email']")
    WebElement emailField;

    @FindBy(css = "input[type='password']")
    WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    WebElement submitButton;

    public LoginPage provideEmail(String email){

        emailField.sendKeys(email);
        return this;

    }

    public LoginPage providePassword(String password){

        passwordField.sendKeys(password);
        return this;

    }

    public LoginPage clickSubmit(){

        click(submitButton);
        return this;

    }

    public LoginPage login(){

        provideEmail("kcroker@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        return this;

    }

}