import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Visibility;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
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
        //WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
      //  WebDriverManager.edgedriver().setup();
    }
    public static WebDriver driver = null;
    WebDriverWait wait;
    public static String url = null;
    public static Actions actions = null;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return threadDriver.get();
    }
    String newPlaylistName = "Renamed Playlist";
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws InterruptedException, MalformedURLException {
//the old way before switchcase options       ChromeOptions options = new ChromeOptions();
//the old way before switchcase options       options.addArguments("--remote-allow-origins=*");
//the old way before switchcase options       driver = new ChromeDriver(options);
//the old way before switchcase options driver = new FirefoxDriver();

//the old way before switchcase options        EdgeOptions options = new EdgeOptions();
//the old way before switchcase options/       options.addArguments("--remote-allow-origins=*");
//the old way before switchcase options        options.addArguments("--disable-notifications");
//the old way before switchcase options        driver = new EdgeDriver(options);
// teacher recommendation if needed            options.addArguments("--disable-notifications");
        threadDriver.set(pickBrowser(System.getProperty("browser")));

        //next we call the getDriver method which returns the current instance of the webdriver with the current thread
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(BaseURL);
        url = BaseURL;
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        actions = new Actions(getDriver());
        //driver.manage().window().maximize;
    }
    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.0.0.208:4444";
        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote allow origins=*");
                edgeOptions.addArguments("--disable-notifications");
                return driver = new EdgeDriver(edgeOptions);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                try {
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                try {
                    return driver= new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                try {
                    return  driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            case "lambda":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                return driver = new ChromeDriver(options);
        }
    }


    public static WebDriver lambdaTest() throws MalformedURLException{
        String hubURL = "https://hub.lambdatest.com/wd/hub";
        String accessToken ="zl4feoCHKb3Qf2Nu9GtJTzqxvKHfg9gH76AVb49JfwYONaDRGf";
        String username = "esther.foshee";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("114.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "esther.foshee");
        ltOptions.put("accessKey", "zl4feoCHKb3Qf2Nu9GtJTzqxvKHfg9gH76AVb49JfwYONaDRGf");
        ltOptions.put("project", "Untitled");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }
//   removed since it is in the LoginPage POM
//        public void login(){
//        provideEmail();
//        providePassword();
//        logInButton();
//    }
//    public void provideEmail()  {
//        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
//                //driver.findElement(By.cssSelector("input[type='email']"));
//        emailField.click();
//        emailField.clear();
//        emailField.sendKeys("esther.martinez32@gmail.com");
        //Thread.sleep(1000);
  //  }
//    public void provideIncorrectEmail(String email)  {
//        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
//                //driver.findElement(By.cssSelector("input[type='email']"));
//        emailField.click();
//        emailField.clear();
//        emailField.sendKeys(email);
//       // Thread.sleep(1000);
//    }
//    public void providePassword() {
//        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
//                //driver.findElement(By.cssSelector("input[type='password']"));
//        passwordField.click();
//        passwordField.clear();
//        passwordField.sendKeys("Proverbs99!");
        //Thread.sleep(1000);
//    }
//    public void provideIncorrectPassword(String incorrectPassword) {
//        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
//                //driver.findElement(By.cssSelector("input[type='password']"));
//        passwordField.click();
//        passwordField.clear();
//        passwordField.sendKeys(incorrectPassword);
//        //Thread.sleep(1000);
//    }
//    public void logInButton() {
//        WebElement logIn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
//                //driver.findElement(By.cssSelector("button[type='submit']"));
//        logIn.click();
       // Thread.sleep(3000);
//    }

//    public void assertAvatar() {
//        WebElement usersAvatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
//                //driver.findElement(By.cssSelector("img.avatar"));
//        Assert.assertTrue(usersAvatar.isDisplayed());
        //Thread.sleep(1000);
//    }

    public void searchSong()  {
        WebElement songSearch = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='q']")));
                //driver.findElement(By.cssSelector("input[name='q']"));
        songSearch.click();
        songSearch.sendKeys("hand");
        //Thread.sleep(1000);
    }

    public void viewSongs() {
        WebElement viewAll = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section.songs h1 button")));
                //driver.findElement(By.cssSelector("section.songs h1 button"));
        viewAll.click();
      //  Thread.sleep(1000);
    }

    public void findFirstSong()  {
        WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//table[@class='items']/tr[1]/td[2]")));
                //driver.findElement(By.xpath("//section[@id='songResultsWrapper']//table[@class='items']/tr[1]/td[2]"));
        firstSong.click();
       // Thread.sleep(1000);
    }

    public void addSong()  {
        WebElement addTo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//button[2]")));
             //   driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[2]"));

        addTo.click();
        //Thread.sleep(1000);
    }

    public void playlist17() {
        WebElement playList = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[7]")));
             //   driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[7]"));
        playList.click();
        //Thread.sleep(2000);
    }

    public void success()  {
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

    public void provideTestEmail() {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
            //    driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("demo@class.com");
       // Thread.sleep(1000);
    }

    public void provideTestPassword()  {
        WebElement passwordField =
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
      //  driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
        //Thread.sleep(3000);
    }

    public void openUserProfilePage()  {
        WebElement avatar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span//img[@class='avatar']")));
            //    driver.findElement(By.xpath("//span//img[@class='avatar']"));
        avatar.click();
        //Thread.sleep(1000);
    }

    public void setCurrentPassword()  {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inputProfileCurrentPassword']")));
               // driver.findElement(By.xpath("//*[@id='inputProfileCurrentPassword']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
       //Thread.sleep(1000);
    }

    public void setNewName(String newName)  {
        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inputProfileName']")));
             //   driver.findElement(By.xpath("//*[@id='inputProfileName']"));
        nameField.click();
        nameField.clear();
        nameField.sendKeys(newName);
        //Thread.sleep(1000);
    }

    public void saveProfile()  {
        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@data-testid='update-profile-form']//button[@type='submit']")));
              //  driver.findElement(By.xpath("//form[@data-testid='update-profile-form']//button[@type='submit']"));
        save.click();
       // Thread.sleep(2000);
    }




//    @AfterMethod //without parallel execution
//    public void closeBrowser() {
//        driver.quit();
//
//    }

    @AfterMethod//for parallel execution
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }

    public void enterNewPlaylistName(){
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[5]")));
        actions.doubleClick(playlist).perform();
        WebElement playlistTextField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistTextField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        //element is required so clear does not work. ctrl a (to select all) then backspace
        playlistTextField.sendKeys(newPlaylistName);
        playlistTextField.sendKeys(Keys.ENTER);
    }

    public boolean validateRenamedPlaylist(){
        WebElement renamedPlaylist = driver.findElement(By.xpath("//a[contains(text(),'"+newPlaylistName+"')]"));
        return renamedPlaylist.isDisplayed();
    }
}
//    @BeforeMethod
//    @Parameters({"BaseURL"})
//    public static void navigateToPage(String BaseURL) throws InterruptedException {
//        driver.get(BaseURL);
//        Thread.sleep(1000);
//    }