package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;


    public BasePage (WebDriver givenDriver){
        driver = givenDriver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10) );

    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
   public void doubleClick(By locator) {
       actions.doubleClick(findElement(locator)).perform();
        }

    }

