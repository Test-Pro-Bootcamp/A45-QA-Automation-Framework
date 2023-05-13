package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "img[class = 'avatar']")
    WebElement avatarIcon;
    @FindBy(css = ".playlist:nth-child(3)")
    WebElement firstPlaylist;
    @FindBy(css = "[name = 'name']")
    WebElement playlistNameField;

    //Fluent Interface
    public HomePage doubleClickPlaylist() {
        doubleClick (firstPlaylist);
        return this;

    }
    public HomePage clickAvatarIcon() {
       click(avatarIcon);
       return this;
    }

    public HomePage enterNewPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.COMMAND , "A", Keys.DELETE ));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
        return this;
    }

    public String getPlaylistName() {return findElement(firstPlaylist).getText();
    }

    public boolean isAvatarDisplayed() {return avatarIcon.isDisplayed();
    }

//      public boolean doesPlaylistExist(String playlistName){
//        By newPlaylist = By.xpath("//a[text()='"+playlistName+"']");
//        return findElement(newPlaylist.isDisplayed());

}








