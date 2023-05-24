import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class HomeWork21 extends BaseTest{
    @Test
    public void renamePlayList () throws InterruptedException{

        provideEmail("pavel.furnic@testpro.io");
        providePassword("Test123456789@");
        clickSubmit();


        WebElement selectPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[position()]")));
        actions.doubleClick(selectPlayList).perform();

        WebElement playlistInputName =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));
        playlistInputName.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
        playlistInputName.sendKeys("New Play List");
        playlistInputName.sendKeys(Keys.ENTER);

        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
        assert  playListElement.isDisplayed();

    }

}
