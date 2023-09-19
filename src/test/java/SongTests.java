import org.testng.Assert;
import org.testng.annotations.Test;
import pom.AllSongs;
import pom.HomePage;
import pom.LoginPage;

public class SongTests extends BaseTest {

    @Test
    public void playAnySong() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongs allSongs = new AllSongs(driver);

        loginPage.login();
        homePage.viewAllSongs();
//        allSongs.findFirstSong();
        allSongs.playNextSong();
        allSongs.playBtn();
//
//        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bars']")));
////          driver.findElement(By.xpath("//div[@class='bars']"));
        Assert.assertTrue(allSongs.isSoundBarDisplayed());
    }
    }


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


