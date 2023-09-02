import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class RandomTests extends BaseTest {

    @Test
    public void actionMethods() { //need review
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        doubleClickChoosePlaylist();

//        hoverPlay();
//        contextClickFirstSong();
    }

    @Test
    public void listOfSongsWebElements() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        displayAllSongs();
    }
    @Test
    public void registrationNavigation()  {

        WebElement registrationLink = getThreadLocal().findElement(By.cssSelector("a[href*='registration']"));
        registrationLink.click();

        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(getThreadLocal().getCurrentUrl(), registrationUrl);

    }

    @Test
    public void playASongTest(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }

}
