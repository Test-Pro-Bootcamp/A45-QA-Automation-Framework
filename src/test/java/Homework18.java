import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        provideEmail();
        providePassword();
        logInButton();

        WebElement allSongs = driver.findElement(By.xpath("//a[@class='songs']"));
        allSongs.click();

        WebElement firstSong = driver.findElement(By.xpath("//td[contains(text(),'Waiting')]"));
        firstSong.click();
        Thread.sleep(2000);

        WebElement playNextSong = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        playNextSong.click();

        WebElement playSong = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playSong.click();

        WebElement soundBar = driver.findElement(By.xpath("//div[@class='bars']"));
        Thread.sleep(2000);
        soundBar.isDisplayed();
        }}


