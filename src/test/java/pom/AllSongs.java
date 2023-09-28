package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AllSongs extends BasePage{
    public AllSongs(WebDriver givenDriver){
        super(givenDriver);
    }
    private By firstSong = By.xpath("//section[@id='songsWrapper']//table[@class='items']/tr[1]/td[2]");
//    public void viewSongs() {
//        WebElement viewAll = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section.songs h1 button")));
        //driver.findElement(By.cssSelector("section.songs h1 button"));
      //  viewAll.click();
        //  Thread.sleep(1000);
    private By addToBTN = By.xpath("//section[@id='songsWrapper']//button[@class='btn-add-to']");
    private By choosePlaylist = By.xpath("//li[@class='playlist']");
    private By playNextSongBTN = By.xpath("//i[@data-testid='play-next-btn']");

    private By playSong = By.xpath("//span[@data-testid='play-btn']");//li[@class='playback']//span[@data-testid='play-btn']

    private By soundBar = By.xpath("//div[@class='bars']");

    public void findFirstSong() {
        findElement(firstSong).click();
        //actions.contextClick(findElement(firstSong));//right click
        //WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//table[@class='items']/tr[1]/td[2]")));
        //driver.findElement(By.xpath("//section[@id='songResultsWrapper']//table[@class='items']/tr[1]/td[2]"));
       //firstSong.click();
        // Thread.sleep(1000);
    }
    public void addToPlaylist(){
        findElement(addToBTN).click();
        findElement(choosePlaylist).click();
    }
    public void playNextSong(){//can't use explicit wait for play button so changed code
        WebElement playNextButton = driver.findElement(playNextSongBTN);
        playNextButton.click();
    }
    public void playBtn(){
        findElement(playSong).click();
    }

    public boolean isSoundBarDisplayed(){
        return findElement(soundBar).isDisplayed();
    }
}
