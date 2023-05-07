package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistNameField = By.cssSelector("[name='name']");

    public void doubleClickFirstPlaylist() {
        doubleClick(firstPlaylist);
    }

    public void enterPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys((Keys.chord(Keys.COMMAND, "A", Keys.DELETE)));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);}

    public String getPlaylistName() {
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        //WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + playlistName + "']")));
        return playlistElement.getText();

    }


        //public String getPlaylistName(){
        //WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + playlistName + "']")));
        //return playlistElement.getText();
    //}

        //public boolean doesPlaylistExist(String playlistName) {
        //WebElement playlistName = driver.findElement(By.xpath("//a[text()='" + playlistName + "']"));
        //By newPlaylist =By.xpath("//a[text()='"+playlistName+"']");
            //return  findElement(newPlaylist).isDisplayed();



    }

    //By newPlaylist =By.xpath('//a[text()='"+playlistName+"']");
        //return findElement(newPlaylist).isDisplayed();



//public boolean doesPlaylistExist(String playlistName) {
//WebElement playlistName = driver.findElement(By.xpath("//a[text()='"+playlistName + "']"));

//return playlistElement.isDisplayed;


//By userAvatarIcon = By.cssSelector("img.avatar");
//public WebElement getUserAvatar () {
// return findElement(userAvatarIcon);




