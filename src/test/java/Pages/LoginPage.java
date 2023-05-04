package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By emailField = By.cssSelector("input[type='email']");

    By passwordField = By.cssSelector("input[type='password']");

    By submitButton = By.cssSelector("button[type='submit']");

    public void provideEmail(String email){

        findElement(emailField).sendKeys(email);

    }

    public void providePassword(String password){

        findElement(passwordField).sendKeys(password);

    }

    public void clickSubmit(){

        findElement(submitButton).click();

    }

    public void login(){

        provideEmail("kcroker@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

    }

}