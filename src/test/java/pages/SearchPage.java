package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class SearchPage extends BasePage {
    @FindBy(css="input[type='search']")
    private WebElement searchField;
    @FindBy(css="section.songs h1 button")
    private WebElement buttonViewAll;
    @FindBy(css="#songResultsWrapper td.title")
    private WebElement firstSongFromList;
    @FindBy(css="button.btn-add-to")
    private WebElement buttonAddTo;
    @FindBy(xpath="// section[@id='songResultsWrapper']//li[contains(text(),'kristina.matskaylo')]")
    private WebElement  uniquePlayList;
    public SearchPage(WebDriver givenDriver) {super(givenDriver);}
    public SearchPage searchSong (String songname) {
        findElement(searchField).clear();
        driver.navigate().refresh();
        findElement(searchField).sendKeys(songname);
        findElement(searchField).click();
        return this;
    }
    public SearchPage clickViewAllButton() {
        findElement(buttonViewAll).click();
        return this;
    }
    public SearchPage selectFirstSongFromSearchResult()  {
        findElement(firstSongFromList).click();
        return this;
    }
    public SearchPage clickAddToButton() {
        findElement(buttonAddTo).click();
        return this;
    }
    public SearchPage choosePlaylistToAdd() {
        findElement(uniquePlayList).click();
        return this;
    }
}
