package pages.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //locators

    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickSubmitBtn;
    @FindBy(xpath = "//input[@type='email']")
    WebElement emailElement;
    @FindBy(xpath = "//input[@type='password']" )
    WebElement passwordElement;

    //Before HW23:
//    By clickSubmit = By.xpath("//button[@type='submit']");
//    By provideEmail = By.xpath("//input[@type='email']");
//    By providePassword = By.xpath("//input[@type='password']");

    public LoginPage (WebDriver givenDriver){
        super(givenDriver);
    }
    public LoginPage clickSubmit (){
        clickSubmitBtn.click();
        return this;
    }
    public LoginPage provideEmail (String email){
        emailElement.sendKeys(email);
        return this;
    }
    public LoginPage providePassword (String password){
        passwordElement.sendKeys(password);
        return this;
    }
    public void login(){
        provideEmail("anton.prymak@testpro.io")
                .providePassword("te$t$tudent")
                .clickSubmit();
    }
}

