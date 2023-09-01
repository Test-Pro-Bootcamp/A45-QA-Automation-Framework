package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.But;
import io.cucumber.java.en_scouse.An;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pom.LoginPage;

import java.time.Duration;

public class LoginStepDefs {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //can also do this instead:
        //@Given("I open browser:)
        //WebDriverManager.chromedriver().setup();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-notifications");
        //options.addArguments("--remote-allow-origins=*");
        //driver = new ChromeDriver(options);
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("I open login page")
    public void openLoginPage() {
        driver.get("https://bbb.testpro.io");
    }

    @When("I enter email {string}")
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys("esther.martinez32@gmail.com");
    }

    @And("I enter password {string}")
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys("Proverbs99!");
    }

    @And("I submit")
    public void submit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();
    }

    @Then("I am logged in")
    public void assertUserLoggedIn() {
        Assert.assertTrue((wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed()));
    }

    @Then("I am not logged in")
    public void assertNotLoggedIn() {
        String url = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), url);//ask czar which one is better
        Assert.assertFalse((wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed()));
    }
}

//using page objects
//@When("I enter email {string}")
//public void enterEmail(String email){
//    LoginPage loginPage = new LoginPage((driver));
//    loginPage.provideEmail(email);
//}