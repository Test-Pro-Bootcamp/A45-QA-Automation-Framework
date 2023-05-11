package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//li[@class='playlist playlist'][1]")
    private WebElement firstPlaylist;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement playlistNameField;
    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public WebElement getUserAvatar () {
        return userAvatarIcon;
    }
    public HomePage doubleClickFirstPlaylist(){
        actions.doubleClick(firstPlaylist).perform();
        return this;
    }
    public HomePage enterNewPlaylistName (String newPlaylistName){
        playlistNameField.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        playlistNameField.sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean doesPlaylistExists(String newPlaylistName){
        By newPlaylist = By.xpath(String.format("//a[text()='%s']",newPlaylistName));
        return findElement(newPlaylist).isDisplayed();
    }

}
