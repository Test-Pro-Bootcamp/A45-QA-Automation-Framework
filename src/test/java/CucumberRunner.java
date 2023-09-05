import io.cucumber.testing.CucumberOptions;
import io.cucumber.testing.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/resources/features/Login.feature"})

public class CucumberRunner {
}
