package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy (css = "[type='email']")
    private WebElement emailField;
    //By emailField = By.cssSelector("input[type='email']");
    //By passwordField = By.cssSelector("input[type='password']");
    @FindBy(css = "[type ='password']")//replaced selector
      private WebElement passwordField;
    //By submitBtn = By.cssSelector("button[type='submit']");
    @FindBy(css = "button[type = 'submit']")
    private WebElement submitButtonLocator;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);}
    //Fluent interface
    public LoginPage provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    //public void provideEmail(String email) {
      //findElement(emailField).sendKeys(email);
    public LoginPage providePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }
    //public void providePassword(String password) {
        //findElement(passwordField).sendKeys(password);
    //}
    public LoginPage clickSubmitBtn() {
        submitButtonLocator.click();
        return this;

    }
    public void login(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}


