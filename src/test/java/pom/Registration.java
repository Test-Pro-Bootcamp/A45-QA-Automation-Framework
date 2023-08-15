package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration extends BasePage{

    public Registration(WebDriver givenDriver){
        super(givenDriver);
    }
    private By registrationBTN = By.cssSelector("a[id='hel']");
    String url = "https://qa.koel.app/registration";
    public void registration(){
        findElement(registrationBTN).click();
    }
}
