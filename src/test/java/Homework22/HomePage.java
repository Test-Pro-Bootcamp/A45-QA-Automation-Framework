package Homework22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By choosePlaylist = By.cssSelector("#playlists > ul > li:nth-child(3)");
    By playlistName = By.cssSelector("[name='name']");
    public void doubleClickPlaylist(){doubleClick(choosePlaylist);}
    public void 
}
