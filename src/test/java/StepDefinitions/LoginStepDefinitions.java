package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinitions {
    private WebDriver driver = null;
    private static WebDriverWait wait = null;
    private int waitTime = 1000;
    private String BaseURL  = "https://bbb.testpro.io/";
    private LoginPage loginPage;
    private HomePage homePage;


    @Given("I open browser")
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
    }

    @And("I open Login Page")
    public void iOpenLoginPage() {
        driver.get(BaseURL);
        loginPage = new LoginPage(driver);
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.providePassword(password);
    }

    @And("I submit")
    public void iSubmit() {
        loginPage.clickSubmit();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        Assert.assertTrue(wait.
                until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("img.avatar"))).isDisplayed());
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }

}
