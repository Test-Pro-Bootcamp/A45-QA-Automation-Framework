package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.UUID;

public class ProfilePreferences extends BasePage{
    public ProfilePreferences(WebDriver givenDriver){
        super(givenDriver);
    }
    private By emailField = By.cssSelector("input[type='email']");
    private By passwordField = By.cssSelector("input[type='password']");
    private By avatar = By.xpath("//span//img[@class='avatar']");
    private By inputPassword = By.xpath("//*[@id='inputProfileCurrentPassword']");
    private By inputName = By.xpath("//*[@id='inputProfileName']");
    private By submit = By.xpath("//form[@data-testid='update-profile-form']//button[@type='submit']");
    private By newProfileName = By.xpath("//span[@class='name']");

    public String getRandomString() {
        return UUID.randomUUID().toString().replace("", "");
    }
    String newName = getRandomString();

    public void openUserProfilePage(){
        findElement(avatar).click();
    }
    public void provideTestEmail (String email){
        findElement(emailField).sendKeys();
    }
    public void provideTestPassword (String password){
        findElement(passwordField).sendKeys();
    }
    public void setCurrentPassword(String password){
        findElement(inputPassword).sendKeys();
    }
    public void setNewName()  {
        findElement(inputName).sendKeys(newName);
    }
    public void saveProfile()  {
        findElement(submit).click();
    }
    public void newProfileName(){
        driver.findElement(newProfileName);
        Assert.assertEquals(newProfileName.getText(), newName);
    }
}
