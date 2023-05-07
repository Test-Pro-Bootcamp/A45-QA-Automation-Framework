package Pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.*;
import java.time.Duration;

public  class LoginPage extends BasePage {
          //WebDriver  driver;
         // WebDriverWait wait;
        // locators
          public LoginPage(WebDriver givenDriver) {
              super(givenDriver);
          }
        By submitButtonLocator=By.cssSelector(["type=’submit’]");
        By emailField=By.cssSelector("[tppe=’email’]");
        By passwordField=By.cssSelector("[type=’password’]");

        public  void clickSubmitBtn() {
            
            findElement(submitButtonLocator).click();
        }
        public  void provideEmail(String email) {
            findElement(emailField).sendKeys(email);
        }
        public  void providePassword(String password){
         findElement(passwordField).sendKeys(password);

        }
        public void login(){
            provideEmail("mengi.gebremedhin@testpro.io");
            providePassword("te$t$tudent");
            clickSubmitBtn();
        }

}
