import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver baseDriver){
        super(baseDriver);
    }

    public void provideEmail(String email){
        getElement(By.cssSelector("input[type='email']")).sendKeys(email);
    }

    public void providePassword(String password){
        getElement(By.cssSelector("input[type='password']")).sendKeys(password);
    }

    public void clickSubmit(){
        getElement(By.cssSelector("button[type='submit']")).click();
    }

    public void login(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }
}
