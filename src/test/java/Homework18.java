import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() {
        navigateToPage();
        provideEmail("bolormaa.zanabaatar@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        click("//i[@data-testid='play-next-btn']");
        click("//span[@data-testid='play-btn']");
        Assert.assertTrue(Playing("//div[@data-testid='sound-bar-play']"));
    }

    public void click(String element) {
        WebElement submit = driver.findElement(By.xpath(element));
        submit.click();
    }

    public boolean Playing(String element){
        WebElement submit = driver.findElement(By.xpath(element));
        return submit.isDisplayed();
    }
}