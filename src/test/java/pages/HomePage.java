package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    String newPlaylistName = null;
    //locator
    @FindBy(css="li.playlist:nth-child(3)")
    private WebElement firstPlaylist;
   //private By firstPlaylist = By.cssSelector("li.playlist:nth-child(3)");
    @FindBy(css="[name='name']")
    private WebElement playlistNameField;
   //private By playlistNameField = By.cssSelector("[name='name']");
    @FindBy(xpath="//a[text()='kristina.matskaylo2']")
    private WebElement newPlaylist;
    @FindBy(css="img.avatar")
    private WebElement userAvatar;

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }
    public HomePage doubleClickFirstPlaylist(){
        doubleClickElement(firstPlaylist);
        return this;
    }

    public HomePage enterNewPLaylistName(String newPlaylistName) {
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        playlistNameField.sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.ENTER);
        return this;
    }
    public boolean doesNewPlaylistexist(String newPlaylisrtName){
        //By newPlaylist = By.xpath("//a[text()='kristina.matskaylo2']");
        // return findElement(newPlaylist).isDisplayed();
        return newPlaylist.isDisplayed();
    }
    public boolean isUserAvatarDisplayed() {
        return userAvatar.isDisplayed();
    }

}
