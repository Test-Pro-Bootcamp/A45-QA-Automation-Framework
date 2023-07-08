package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage (WebDriver givenDriver){
        super(givenDriver);
    }
    @FindBy(css = "input[type='email']")
    private WebElement emailField;
    @FindBy (css = "input[Type='password']")
    private WebElement passwordField;
    @FindBy (css = "button[Type='submit'")
    private WebElement submitBtn;
    public LoginPage provideEmail (String email){
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword (String password){
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit(){
        submitBtn.click();
        return this;
    }
    public LoginPage login() {
        provideEmail("esther.martinez32@gmail.com");
        providePassword("Proverbs99!");
        clickSubmit();
        return this;
    }}







