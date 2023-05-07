import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist(){
        String newPlName = "AlekseiZZZ";
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        isAvatarDisplayed();
        doubleClickPl();
        enterNewPlName(newPlName);
        Assert.assertTrue(doesPlExists(newPlName));
    }

    public boolean doesPlExists(String newPlName) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                String.format("//a[text()='%s']",newPlName)))).isDisplayed();
    }

    public void enterNewPlName(String newPlName) {
        WebElement plInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//input[@name='name']")));
        plInputField.sendKeys(Keys.chord(Keys.COMMAND, "A"));
        plInputField.sendKeys(Keys.BACK_SPACE);
        plInputField.sendKeys(newPlName);
        plInputField.sendKeys(Keys.ENTER);
    }

    public void doubleClickPl() {
        WebElement pl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//li[@class='playlist playlist'][1]")));
        actions.doubleClick(pl).perform();
    }
}
