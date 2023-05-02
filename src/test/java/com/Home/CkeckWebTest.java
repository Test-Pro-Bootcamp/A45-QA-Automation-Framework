package com.Home;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import org.testng.Assert;

import java.time.Duration;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.o;

public class CkeckWebTest extends BaseWebTest {

    @Test

        public void LaunchBrowser() throws InterruptedException{

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url="https://www.travelocity.com";
        driver.get(url);

            WebElement fieldSearch=driver.findElement(By.cssSelector("//input[@id='headerSearch']"));
            fieldSearch.click();
            fieldSearch.clear();
            fieldSearch.sendKeys("Hardwood flooring");
            //fieldSearch.click();
            WebElement searButton=driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M13.415 4.')]"));
            searButton.click();
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.homedepot.com/b/Flooring-Hardwood-Flooring/N-5yc1v");
        //fieldSearch.sendKeys(keys.ENTER);


        /*WebElement passwordField=driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
        WebElement submit=driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
        WebElement avatarIcon=driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertEquals(driver.getCurrentUrl(),url);*/




    }






}
