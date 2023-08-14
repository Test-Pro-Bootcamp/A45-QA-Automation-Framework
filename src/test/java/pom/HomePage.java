package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void assertAvatar() {
        WebElement usersAvatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        //driver.findElement(By.cssSelector("img.avatar")); old code
        Assert.assertTrue(usersAvatar.isDisplayed());
    }

    }

