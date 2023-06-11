import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class SongPLayTests extends  BaseTest {
    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("kristina.matskaylo@testpro.io")
                .providePassword("11111111*a")
                .clickSubmitBtn();
        homePage.clickPlayNextSongButton()
                .clickPlayButton();

        Assert.assertTrue(homePage.songPlaying());
    }

//    private void clickPlayNextSongButton() throws InterruptedException{
//        WebElement playNextSongButton = driver.findElement(By.xpath("//*[@title='Play next song']"));
//        playNextSongButton.click();
//        Thread.sleep(2000);
//    }
//    private void clickPlayButton() throws InterruptedException {
//        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
//        playButton.click();
//        Thread.sleep(2000);
//    }
//    public boolean songPlaying(){
//      WebElement soundBar = driver.findElement(By.xpath("//button[@data-testid='toggle-visualizer-btn']"));
//        return soundBar.isDisplayed();
//    }
}
 