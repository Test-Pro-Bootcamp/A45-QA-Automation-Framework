package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    @FindBy (xpath="//button[@type='submit']")
    WebElement clickSubmit;
    @FindBy (xpath ="//input[@type='email']")
    WebElement provideEmail;
    @FindBy (xpath ="//input[@type='password']")
    WebElement providePassword;


    public LoginPage( WebDriver givenDriver){
        super(givenDriver);
    }
    public LoginPage clickSubmit () {
        clickSubmit.click();
        return this;
    }
    public LoginPage provideEmail( String email){
        provideEmail.sendKeys(email);
        return this;

    }
    public LoginPage providePassword(String password){
        providePassword.sendKeys(password);
        return this;
    }
    public void login(){
        provideEmail("pavel.furnic@testpro.io");
        providePassword("Test123456789@");
        clickSubmit();

    }
}