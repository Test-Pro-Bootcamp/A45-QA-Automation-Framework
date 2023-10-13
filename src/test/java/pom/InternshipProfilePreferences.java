package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class InternshipProfilePreferences extends BasePage{
    public InternshipProfilePreferences(WebDriver givenDriver){
        super(givenDriver);
    }
    private By emailField = By.cssSelector("input[type='email']");
    private By newPasswordField = By.cssSelector("input[id='inputProfileNewPassword']");
    private By avatar = By.xpath("//span//img[@class='avatar']");
    private By provideCurrentPassword = By.cssSelector("input[name='current_password']");
    private By inputName = By.xpath("//*[@id='inputProfileName']");
    private By submit = By.xpath("//form[@data-testid='update-profile-form']//button[@type='submit']");
    private By newProfileName = By.xpath("//span[@class='name']");
    private By popUpMessage = By.cssSelector("div[class='success show']");

    public String getRandomString() {
        return UUID.randomUUID().toString().replace("", "");
    }
    public void openUserProfilePage(){
        findElement(avatar).click();
    }
    public void provideTestEmail (String email){
        findElement(emailField).clear();
        findElement(emailField).sendKeys(email);
    }
    public void provideCurrentPassword (String password){
        findElement(provideCurrentPassword).sendKeys(password);
    }
    public void setNewPassword(String password){
        findElement(newPasswordField).clear();
        findElement(newPasswordField).sendKeys(password);
    }
    public void setNewName(String newName)  {
        findElement(inputName).clear();
        findElement(inputName).sendKeys(newName);
    }
    public void saveProfile()  {
        findElement(submit).click();
    }
        public String profileUpdateSuccess(){
            findElement(popUpMessage);
            return findElement(newProfileName).getText();
    }
}
