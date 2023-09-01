package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.But;

public class LoginStepDefs {
    public LoginStepDefs() {
        Given("^I open login page$", () -> {
        });
        When("^I enter email \"([^\"]*)\"$", (String arg0) -> {
        });
        And("^I enter password \"([^\"]*)\"$", (String arg0) -> {
        });
        And("^I submit$", () -> {
        });
        Then("^I am logged in$", () -> {
        });
    }
}
