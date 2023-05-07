package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

public class HomePage extends BasePage{


        By userAvatarIcon=By.cssSelector("img.avatar");
        By firstPlaylist=By.cssSelector(".playlist:nth-child(3)");
        By playlistNameField=By.cssSelector("[name='name']");
        public HomePage(WebDriver givenDriver) {
            super(givenDriver);
        }
        public void doubleClickPlaylist(){doubleClick(firstPlaylist);}
        public void enterNewPlaylistName(String playlistName){
            findElement(playlistNameField).sendkeys(playlistName);
            findElement(playlistNameField).sendkeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
            findElement(playlistNameField).sendkeys(playlistName);
            findElement(playlistNameField).sendkeys(Keys.ENTER);
        }
        public void boolean doesPlaylistExist(String playlistName){
            By newPlaylist=By.xpath("//a[text()='"+playlistName+"']");
            return findElement(newPlaylist).isDisplayed();
    }
        public WebElement getUserAvatar(){
            return     wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
        }
    }
















}
