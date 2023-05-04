import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//import storg.bouncycastle.cms.RecipientId.password;
//import static org.bouncycastle.cms.RecipientId.email;
public class  HomeWorkTest21  extends BaseTest21 {

    public void renameSongNameTest () throws InterruptedException {
        navigateToPage();
        provideEmail("mengi.gebremedhin@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        hoverPlay();
        clickAllSongsList();
        contextClickFirstSong();
        doubleClickChoosePlaylist();









    }






}
