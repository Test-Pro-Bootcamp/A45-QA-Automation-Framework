package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage (WebDriver givenDriver) {
        super (givenDriver);
    }


    @FindBy (css = "[type='email']")
    WebElement emailField;
    @FindBy (css = "[type='password']" )
    WebElement passwordField;
    @FindBy (css = "button[type='submit']" )
    WebElement submitBtn;
   //private By emailField = By.cssSelector("[type='email']");
   //private  By passwordField = By.cssSelector("[type='password']");
    // private By submitBtn = By.cssSelector("button[type='submit']");


    public void enterEmail (String email) {
        emailField.sendKeys(email);
    }
    public void enterPassword (String password) {
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        submitBtn.click();
    }
    public void login() {
        enterEmail("agnes.albertusiak@testpro.io");
        enterPassword("te$tStudent1");
        clickSubmit();
    }
}
