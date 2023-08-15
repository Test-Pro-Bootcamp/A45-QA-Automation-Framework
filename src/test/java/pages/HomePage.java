package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {
    String playlistName = "TestPro Playlist";
    private By locator;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Web element annotations
    @FindBy(css ="img.avatar")
    private WebElement userAvatarIcon;
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement firstPlaylist;
    @FindBy(css = "[name = 'name']")
    private WebElement playlistNameField;

//    Methods
    public WebElement getUserAvatar() {
        return userAvatarIcon;
    }
    public WebElement getFirstPlaylist() {
        return firstPlaylist;
    }
    public WebElement getPlaylistNameField() {
        return playlistNameField;
    }
    public void clickAvatarIcon() {
        userAvatarIcon.click();
    }
    public void enterNewPlaylistName() {
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist() {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='" + playlistName + "']"));
        return playlistElement.isDisplayed();

    }

    public void openPlaylist() {
        WebElement emptyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        emptyPlaylist.click();

    }

    public void deletePlaylist() {
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        deletePlaylistButton.click();

    }

    public void doubleClickPlaylist() {
        actions.doubleClick(findElement(locator)).perform();
    }
}

