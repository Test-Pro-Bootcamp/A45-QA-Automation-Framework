package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    //locators

    @FindBy(css="[type='submit']")
    private WebElement submitButtonLocator;
    @FindBy(css="[type='email']")
    private WebElement emailField;
    @FindBy(css="[type='password']")
    private WebElement passwordField;

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }
    public LoginPage provideEmail(String email){
       // WebElement emailElement = driver.findElement(emailField);
       // emailElement.clear();
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password){
       // WebElement emailElement = driver.findElement(passwordField);
       // passwordElement.clear();
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmitBtn(){
        //driver.findElement(submitButtonLocator).click();
        submitButtonLocator.click();
        return this;
    }
    public boolean isClickSubmitBtnDisplayed(){
        return submitButtonLocator.isDisplayed();
    }


}
