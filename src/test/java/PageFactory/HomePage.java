package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.swing.text.html.CSS;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = ".playlist:nth-child(3)")
    WebElement firstPlaylist;
    @FindBy(css = "[name='name']")
            WebElement playlistNameField;

    @FindBy(css = "div.success.show")
    WebElement popUpNotification;

    public HomePage doubleClickPlaylist() {
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
//       // By newPlaylist = By.xpath("//a[text()='"+playlistName+"']");
//        @FindBy(xpath ="//a[text()='"+playlistName+"']")
//          WebElement newPlaylist;
//        return findElement(newPlaylist).isDisplayed();
//    }

    public String getPlaylistName() {
        findElement(popUpNotification);
        return findElement(firstPlaylist).getText();
    }


}
