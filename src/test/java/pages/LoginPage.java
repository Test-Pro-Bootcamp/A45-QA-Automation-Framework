package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends BasePage {
    @FindBy(css="[type='submit']")
    private WebElement submitButtonLocator;
    @FindBy(css="[type='email']")
    private WebElement emailField;
    @FindBy(css="[type='password']")
    private WebElement passwordField;

    @FindBy(css="#hel")
    private WebElement registrationSign;

    public LoginPage(WebDriver givenDriver){
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
    public LoginPage clickSubmitBtn(){
        findElement(submitButtonLocator).click();
        return this;
    }
    public boolean isClickSubmitBtnDisplayed(){
        return findElement(submitButtonLocator).isDisplayed();
    }

    public LoginPage clickRegistrationSign(){
        findElement(registrationSign).click();
       return this;
    }
}
