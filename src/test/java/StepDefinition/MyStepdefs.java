package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginStepDefinition {

    WebDriver driver;
    WebDriverWait wait;

@Before

    @Given("You open browser")
    public void youOpenBrowser() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications");
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
@After
public void closeBrowser() {driver.quit();}
    @And("You open login page")
    public void youOpenLoginPage() {driver.get("https://bbb.testpro.io/");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String arg0) {
    }


    @And("I enter password {string}")
    public void iEnterPassword(String arg0) {
    }

    @And("I submit")
    public void iSubmit() {
    }

    @Then("I am login in")
    public void iAmLoginIn() {
    }

    @And("I open Login Page")
    public void iOpenLoginPage() {
    }
}
