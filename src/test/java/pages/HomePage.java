package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
//    By userAvatarIcon = By.cssSelector("img.avatar");
    @FindBy(css="img.avatar")
    WebElement userAvatarIcon;
    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }

}
