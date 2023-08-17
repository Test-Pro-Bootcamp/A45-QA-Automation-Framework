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


    public void findFirstSong() {
        findElement(firstSong).click();
        //WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//table[@class='items']/tr[1]/td[2]")));
        //driver.findElement(By.xpath("//section[@id='songResultsWrapper']//table[@class='items']/tr[1]/td[2]"));
       //firstSong.click();
        // Thread.sleep(1000);
    }
    public void addToPlaylist(){
        findElement(addToBTN).click();
    }
}
