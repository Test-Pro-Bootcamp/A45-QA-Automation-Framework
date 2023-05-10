package Homework22;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
//    By emailField = By.cssSelector("input[type='email']");
//    By passwordField = By.cssSelector("input[type='password']");
//    By submitButton = By.cssSelector("button[type='submit']");
    @FindBy(css = "button[type='submit']")
    WebElement submitButton;
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
   @FindBy(css = "input[type='email']")
   WebElement emailField;

    public void provideEmail(String email){
        emailField.sendKeys(email);
    }
    public void providePassword(String password){
        passwordField.sendKeys(password);
    }
    public void setSubmitButton(){
        submitButton.click();
    }
    public void logIn(){
        provideEmail("heavenmayhem@gmail.com");
        providePassword("Everything2Me0628!");
        setSubmitButton();
    }
}
