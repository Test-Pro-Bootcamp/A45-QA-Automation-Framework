package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends BasePage {

    @FindBy (css = "button[type='submit']")
    private WebElement submitButtonLocator;
    @FindBy (css = "input[type='email']")
    private WebElement emailField;
    @FindBy (css = "input[type='password']")
    private WebElement passwordFieldBox;


    public LoginPage (WebDriver givenDriver) {
        super(givenDriver);
    }
    public LoginPage clickSubmitBtn () {
        submitButtonLocator.click();
        return this;
    }
    public LoginPage provideEmail (String email) {
        WebElement emailElement = emailField;
        emailElement.click();
        emailElement.clear();
        emailElement.sendKeys(email);
        return this;
    }
    public LoginPage providePassword (String password) {
        WebElement passwordField = passwordFieldBox;
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage login () {
    provideEmail("asdASD@mail.com");
    providePassword("te$t$tudent");
    clickSubmitBtn();
    return this;
    }
    public LoginPage submitBtnDisplayed () {
        Assert.assertTrue(submitButtonLocator.isDisplayed());
        return this;
    }
}
