package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver givenDriver) {super(givenDriver);}
    @FindBy(css = ".all-songs tr.song-item:nth-child(1)")
    WebElement firstSong;
    public AllSongsPage contextClickFirstSong(){contextClick(firstSong);
    return this;}
}
