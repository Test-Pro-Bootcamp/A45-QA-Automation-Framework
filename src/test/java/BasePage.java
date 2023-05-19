import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    public BasePage(WebDriver baseDriver){
        driver = baseDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        actions = new Actions(driver);
    }

    public WebElement getElement(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void click(By element){
        actions.doubleClick(getElement(element)).perform();
    }
}