package PageFactory;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

   // By emailField = By.cssSelector("input[type='email']");
    @FindBy(css = "input[type='email']" )
    WebElement emailField;
   // By passwordField = By.cssSelector("input[type='password']");
    @FindBy(css = "input[type='password']")
           WebElement passwordField;

    //By submitBtn = By.cssSelector("button[type='submit']");
    @FindBy(css = "button[type='submit']" )
    WebElement submitBtn;

//    public void provideEmail(String email) {
//        findElement(emailField).sendKeys(email);
//    }

    public LoginPage provideEmail(String email) {
        findElement(emailField).sendKeys(email);
        return this;
    }


    public LoginPage providePassword(String password) {
        findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        findElement(submitBtn).click();
        return this;
    }

    public LoginPage login() {
        provideEmail("pdr.deepthi@gmail.com");
        providePassword("te$t$tudent1");
        clickSubmit();
        return this;
    }
}


