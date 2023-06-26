package Definitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class LoginStepDefinitions {
    WebDriver driver;

    WebDriverWait wait;

    @Before
    @Given("I open browser")

    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("I open login page")
    public void openLoginPage() {
        driver.get("https://qa.koel.app/");}

    @When("I enter email {string}")
    public void iEnterEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']"))).sendKeys(email);}

    @And("I enter password {string}")
    public void iEnterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']"))).sendKeys(password);}

    @And ("I submit")
    public void clickSubmit(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();}

    @Then("I am logged in")
    public void userIsLoggedIn (){

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }

}
