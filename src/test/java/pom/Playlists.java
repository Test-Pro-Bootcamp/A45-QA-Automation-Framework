package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Playlists extends BasePage {
    public Playlists(WebDriver givenDriver) {
        super(givenDriver);
    }
    private By findPlaylist = By.xpath("//nav[@class='menu playlist-item-menu']//li[2]");
    private By playlistNameField = By.cssSelector("input[name='name']");
    private By playlist = By.xpath("//section[@id='songResultsWrapper']//button[2]");
    private By success = By.xpath("//div[@class='success show']");
    private By selectPlaylist = By.xpath("//section[@id='playlists']//li[5]");
    private By deletePlaylist = By.xpath("//button[@class='del btn-delete-playlist']");
    public void doubleClickPlaylist() {
        doubleClick(findPlaylist);
    }
    public void enterNewPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys((Keys.ENTER));
    }
    public boolean doesPlaylistExist(String playlistName) {
        By newPlaylist = By.xpath("//a[text()='" + playlistName + "']");
        return findElement(newPlaylist).isDisplayed();
    }
    public void addSongToPlaylist() {
        findElement(playlist).click();
    }
    public void selectPlaylist(){
        findElement(selectPlaylist).click();
    }
    public void deletePlaylist(){
        findElement(deletePlaylist).click();
    }
    public String getSuccessMsg() {
        findElement(success);
        return findElement(success).getText();
        //Assert.assertTrue(success.getText().contains("Added 1 song into"));
                //assertEquals(verification.getText(), "Added 1 song into \"homework17.\"");
    }
}
// WebElement playList = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[7]")));
//   driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[7]"));
// playList.click();
//Thread.sleep(2000);
//    public void addSongToPlaylist() {
//        WebElement addTo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//button[2]")));
//   driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[2]"));

//    addTo.click();
//Thread.sleep(1000);
// }
//WebElement verification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
//driver.findElement(By.xpath("//div[@class='success show']"));

//    public void enterNewPlaylistName(){
//        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[5]")));
//        actions.doubleClick(playlist).perform();
//        WebElement playlistTextField = driver.findElement(By.cssSelector("input[name='name']"));
//        playlistTextField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
//        //element is required so clear does not work. ctrl a (to select all) then backspace
//        playlistTextField.sendKeys(newPlaylistName);
//        playlistTextField.sendKeys(Keys.ENTER);
//    }

//    public boolean validateRenamedPlaylist(){
//        WebElement renamedPlaylist = driver.findElement(By.xpath("//a[contains(text(),'"+newPlaylistName+"')]"));
//        return renamedPlaylist.isDisplayed();