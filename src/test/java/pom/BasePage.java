package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    public BasePage(WebDriver givenDriver){
        driver=givenDriver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        actions=new Actions(driver);
    }
    private By loadingBar = By.cssSelector("#overlay");
    public void waitForLoadingBarToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBar));
    }
    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void doubleClick(By locator){

        actions.doubleClick(findElement(locator)).perform();
}
}
