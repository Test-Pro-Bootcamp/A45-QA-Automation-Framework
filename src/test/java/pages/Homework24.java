import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {
    private static final String GRID_URL = "http://localhost:4444/wd/hub";

    public static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();


        try {
            return new RemoteWebDriver(new URL(GRID_URL), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

public class TestScenario {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getChromeDriver();
        driver.get("https://example.com");


        driver.quit();
    }
}
