package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    private By emailField = By.cssSelector("input[type='email']");
    private By passwordField = By.cssSelector("input[Type='password']");
    private By submitBtn= By.cssSelector("button[Type='submit'");

    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password){
        findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit(){
        findElement(submitBtn).click();
    }
    public void login(){
        provideEmail("esther.martinez32@gmail.com");
        providePassword("Proverbs99!");
        clickSubmit();
    }
    public void provideIncorrectEmail(String email) {
        findElement(emailField).sendKeys(email);
    }
    public void provideIncorrectPassword(String password){
        findElement(passwordField).sendKeys(password);
    }


        //driver.findElement(By.cssSelector("input[type='email']")); old code
//        emailField.click();
//        emailField.clear();
//        emailField.sendKeys(email);
}
