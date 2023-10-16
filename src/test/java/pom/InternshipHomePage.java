package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InternshipHomePage extends BasePage{
    public InternshipHomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By searchfield = By.cssSelector("input[name='q']");
    private By allSongs = By.xpath("//section[@class='music']//li[3]//a[@class='songs']");
    private By userAvatar = By.cssSelector("img.avatar");
    private By logoutBtn = By.cssSelector("a[data-testid='btn-logout']");

    public WebElement assertAvatar() {
        return findElement(userAvatar);
        //WebElement usersAvatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        //driver.findElement(By.cssSelector("img.avatar")); old code
        //  Assert.assertTrue(usersAvatar.isDisplayed());
    }
    public void searchSong() {
        findElement(searchfield).sendKeys("hand");
        //WebElement songSearch = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='q']")));
        //driver.findElement(By.cssSelector("input[name='q']"));
        //songSearch.click();
        //songSearch.sendKeys("hand");
        //Thread.sleep(1000);
    }
    public void viewAllSongs(){
        findElement(allSongs).click();
    }
public void logout(){
        findElement(logoutBtn).click();
}
}


