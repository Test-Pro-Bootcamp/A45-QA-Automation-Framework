package pages.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;

    @FindBy(xpath = "//section[@id='playlists']//li[@class='playlist playlist']//a[position()]")
    private WebElement firstPlaylist;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement playlistNameField;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
        PageFactory.initElements(givenDriver, this);
    }

    public WebElement getUserAvatar() {
        return userAvatarIcon;
    }

    public HomePage doubleCLickPlaylist() {
        actions.doubleClick(firstPlaylist).perform();
        return this;
    }

    public HomePage enterNewPlaylistName(String playlistName) {
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistNameField.sendKeys(playlistName);
        playlistNameField.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean doesPlaylistExist(String playlistName) {
        By newPlaylist = By.xpath("//a[text()='" + playlistName + "']");
        return findElement(newPlaylist).isDisplayed();
    }
}

