import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pom.AllSongs;
import pom.LoginPage;

public class PlaySong extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        AllSongs allSongs = new AllSongs(getDriver());

        loginPage.login();

    }
//        provideEmail();
//        providePassword();
//        logInButton();
//
//        WebElement allSongs = driver.findElement(By.xpath("//a[@class='songs']"));
//        allSongs.click();
//
//        WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'Waiting')]")));
//              //  driver.findElement(By.xpath("//td[contains(text(),'Waiting')]"));
//        firstSong.click();
//       // Thread.sleep(2000);
//
//        WebElement playNextSong = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
//        playNextSong.click();
//
//        WebElement playSong = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
//        playSong.click();
//
//        WebElement soundBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bars']")));
//              //  driver.findElement(By.xpath("//div[@class='bars']"));
//       //Thread.sleep(2000);
//        soundBar.isDisplayed();
//        }}


