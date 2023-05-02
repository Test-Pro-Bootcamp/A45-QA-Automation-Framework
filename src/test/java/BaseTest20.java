import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest20 {
    public static WebDriver driver=null;
    public static String url="https://bbb.testpro.io";
    @BeforeSuite
    static void setUpClass() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void launchBrowser(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins--");
        driver=new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    public static void navigateToPage(){
        driver.get(url);
    }
    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebDriverWait wait=new WebDriverWait(driver.wait(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.click();
        emailField.clear();

        emailField.sendKeys(email);
    }
    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebDriverWait wait=new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public static void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
    }
    public  void searchSongl(String songTitleKeyword) throws InterruptedException{
        WebElement searchField = driver.findElement(By.cssSelector("div/searchform input[type='search']"));
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div/searchform input[type='search']")));
        searchField.sendKeys(songTitleKeyword);
        //Thread.sleep(2000);
    }
    public static void clickViewAllBtn() throws InterruptedException{
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div,results section.songs h1 button"));
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div,results section.songs h1 button")));
        viewAllSearchResult.click();

        //Thread.sleep(2000);
    }
    public static void selectFirstSongResult() throws InterruptedException {
        WebElement firstSongResult = driver.findElement(By.cssSelector("sectionsongResultswrapper tr.song-item td.title"));
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("sectionsongResultswrapper tr.song-item td.title")));
        firstSongResult.click();
        //Thread.sleep(2000);
    }
    public  void clickAddBtn() throws InterruptedException{
        WebElement addToBtn=driver.findElement(By.cssSelector("button.btn-add-to"));
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-add-to")));
        addToBtn.click();
        //Thread.sleep(2000);
        }
    public void playListAdded() throws InterruptedException {
            //we created a playlist named "test pro playlist";
            WebElement  playElement=driver.findElement(By.cssSelector("//section[id='songResultswrapper']//li[contains(text(),'Test pro playlist')]"));
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//section[id='songResultswrapper']//li[contains(text(),'Test pro playlist')]")));
            playElement.click();
            //Thread.sleep(2000);
        }
    public String getNotificationText()   throws InterruptedException{
            WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
            WebDriverWait wait=new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
            return notificationElement.getText();

        }



    }










