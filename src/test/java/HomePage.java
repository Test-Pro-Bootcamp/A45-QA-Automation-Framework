import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver baseDriver){
        super(baseDriver);
    }

    public void click() {
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(submit).perform();
    }

    public void addPlaylist() {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        input.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        input.sendKeys("Test");
        input.sendKeys(Keys.ENTER);
    }

    public boolean playListExist() {
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Test']")));
        return submit.isDisplayed();
    }
}
