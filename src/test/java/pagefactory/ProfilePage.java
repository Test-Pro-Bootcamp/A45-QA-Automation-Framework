package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "[name='current_password']")
    WebElement currentPasswordField;
    @FindBy(css = "[name='name']")
    WebElement profileNameField;
    @FindBy(css = "button.btn-submit")
    WebElement saveBtn;

    @FindBy(css = "a.view-profile>span")
    WebElement profileName;

    @FindBy(css = "div.success.show")
    WebElement profileUpdatedMsg;


    public static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    public ProfilePage provideCurrentPassword(String password) {
        findElement(currentPasswordField).clear();
        findElement(currentPasswordField).sendKeys(password);
        return this;
    }
    public ProfilePage provideProfileName(String randomName) {
        findElement(profileNameField).clear();
        findElement(profileNameField).sendKeys(randomName);
        return this;
    }
    public ProfilePage clickSaveButton() {
       click(saveBtn);
       return this;
    }
    public String getCurrentProfileName(){
        findElement(profileUpdatedMsg);
        return findElement(profileName).getText();
    }
}
