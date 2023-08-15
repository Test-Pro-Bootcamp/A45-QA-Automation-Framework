package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Web element annotations
   @FindBy(css = "[type='email']")
   private WebElement emailField;
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    @FindBy(css ="button[type='submit']" )
    private static WebElement submitBtn;
    //By submitBtn = By.cssSelector("button[type='submit']");
    @FindBy(css = "a#hel")
    private WebElement registrationLink;
    @FindBy(css = ".fa-sign-out")
    private WebElement logOutLocator;

//Methods for interaction
    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
//    public void provideEmail(String email) {
//      findElement(emailField).sendKeys(email);
    }
    public LoginPage providePassword(String password) {
       passwordField.sendKeys(password);
       return this;
    }
    public static void clickSubmit() {
        submitBtn.click();
    }
    public void login(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }
    public WebElement getRegistrationLink() {
        return registrationLink;
    }

    public LoginPage clickLogOut() {
        logOutLocator.click();
        return this;
    }
}


