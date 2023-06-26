import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Visibility;
import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    @DataProvider(name = "IncorrectData")
    public static Object[][] IncorrectDataLogIn() {
        return new Object[][]{
                {"invalid@mail.com", "invalidPass"},
                {"esther.martinez32@gmail.com", ""},
                {"", ""}
        };
    }

    @BeforeSuite
     void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    public WebDriver driver = null;
    WebDriverWait wait;
    public static String url = null;
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(BaseURL);
        Thread.sleep(2000);
        url = BaseURL;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void provideEmail() throws InterruptedException {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
                //driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("esther.martinez32@gmail.com");
        //Thread.sleep(1000);
    }
    public void provideIncorrectEmail(String email) throws InterruptedException {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
                //driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
       // Thread.sleep(1000);
    }
    public void providePassword() throws InterruptedException {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
                //driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("Proverbs99!");
        //Thread.sleep(1000);
    }
    public void provideIncorrectPassword(String incorrectPassword) throws InterruptedException {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
                //driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(incorrectPassword);
        //Thread.sleep(1000);
    }
    public void logInButton() throws InterruptedException{
        WebElement logIn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
                //driver.findElement(By.cssSelector("button[type='submit']"));
        logIn.click();
       // Thread.sleep(3000);
    }

    public void assertAvatar() throws InterruptedException {
        WebElement usersAvatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
                //driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(usersAvatar.isDisplayed());
        //Thread.sleep(1000);
    }

    public void searchSong() throws InterruptedException {
        WebElement songSearch = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='q']")));
                //driver.findElement(By.cssSelector("input[name='q']"));
        songSearch.click();
        songSearch.sendKeys("hand");
        //Thread.sleep(1000);
    }

    public void viewSongs() throws InterruptedException {
        WebElement viewAll = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section.songs h1 button")));
                //driver.findElement(By.cssSelector("section.songs h1 button"));
        viewAll.click();
      //  Thread.sleep(1000);
    }

    public void findFirstSong() throws InterruptedException {
        WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//table[@class='items']/tr[1]/td[2]")));
                //driver.findElement(By.xpath("//section[@id='songResultsWrapper']//table[@class='items']/tr[1]/td[2]"));
        firstSong.click();
       // Thread.sleep(1000);
    }

    public void addSong() throws InterruptedException {
        WebElement addTo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//button[2]")));
             //   driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[2]"));

        addTo.click();
        //Thread.sleep(1000);
    }

    public void playlist17() throws InterruptedException {
        WebElement playList = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[7]")));
             //   driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[7]"));
        playList.click();
        //Thread.sleep(2000);
    }

    public void success() throws InterruptedException {
        WebElement verification =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
        //driver.findElement(By.xpath("//div[@class='success show']"));
        //Thread.sleep(2000);
        Assert.assertEquals(verification.getText(), "Added 1 song into \"homework17.\"");
    }

    //for ProfileTest
    public String getRandomString() {
        return UUID.randomUUID().toString().replace("", "");
    }

    public void provideTestEmail() throws InterruptedException {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
            //    driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("demo@class.com");
       // Thread.sleep(1000);
    }

    public void provideTestPassword() throws InterruptedException {
        WebElement passwordField =
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
      //  driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
        //Thread.sleep(3000);
    }

    public void openUserProfilePage() throws InterruptedException {
        WebElement avatar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span//img[@class='avatar']")));
            //    driver.findElement(By.xpath("//span//img[@class='avatar']"));
        avatar.click();
        //Thread.sleep(1000);
    }

    public void setCurrentPassword() throws InterruptedException {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inputProfileCurrentPassword']")));
               // driver.findElement(By.xpath("//*[@id='inputProfileCurrentPassword']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
       //Thread.sleep(1000);
    }

    public void setNewName(String newName) throws InterruptedException {
        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inputProfileName']")));
             //   driver.findElement(By.xpath("//*[@id='inputProfileName']"));
        nameField.click();
        nameField.clear();
        nameField.sendKeys(newName);
        //Thread.sleep(1000);
    }

    public void saveProfile() throws InterruptedException {
        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@data-testid='update-profile-form']//button[@type='submit']")));
              //  driver.findElement(By.xpath("//form[@data-testid='update-profile-form']//button[@type='submit']"));
        save.click();
       // Thread.sleep(2000);
    }




    @AfterMethod
    public void closeBrowser() {
        driver.quit();

    }
}
//    @BeforeMethod
//    @Parameters({"BaseURL"})
//    public static void navigateToPage(String BaseURL) throws InterruptedException {
//        driver.get(BaseURL);
//        Thread.sleep(1000);
//    }