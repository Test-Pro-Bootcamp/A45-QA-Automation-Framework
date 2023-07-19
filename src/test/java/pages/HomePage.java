package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By userAvatarIcon = By.cssSelector("img.avatar");

    @FindBy(css =".playlist:nth-child(3)")
            WebElement firstPlaylist;
    @FindBy(css ="[name='name']" )
            WebElement playlistNameField;
    @FindBy(css = "div.success.show")
    WebElement popUpNotification;


    public HomePage doubleClickChoosePlaylist() {
        doubleClick(firstPlaylist);
        return this;
    }
    public HomePage enterNewPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    return this;
    }
//    public boolean doesPlaylistExist(String playlistName) {
//        By newPlaylist = By.xpath("//a[text()='"+playlistName+"']");
//        return findElement(newPlaylist).isDisplayed();
//    }
public String getPlaylistName() {
    findElement(popUpNotification);
    return findElement(firstPlaylist).getText();
}
}
