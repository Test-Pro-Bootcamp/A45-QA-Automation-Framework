<dependencies>
<dependency>
<groupId>org.seleniumhq.selenium</groupId>
<artifactId>selenium-java</artifactId>
<version>3.141.59</version>
</dependency>
<dependency>
<groupId>org.testng</groupId>
<artifactId>testng</artifactId>
<version>7.3.0</version>
</dependency>
</dependencies>

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.URL;

public class LambdaTestExampleTest {
    private WebDriver driver;
    private String username = "deimante.juskyte";
    private String accessKey = "Jo3sguaRcLtIcDszRcAhvUe5iasJOfPNpPsvaWeRMCsiLFN4Za";
    private String gridURL = "@hub.lambdatest.com/wd/hub";

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "macOS 13.3.1 (a) (22E772610a)");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "112.0.5615.137 (Official Build) (arm64)");

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + gridURL), caps);
    }

    @Test
    public void testLambdaTestExample() {
        driver.get("https://www.google.com/");
        WebElement titleElement = driver.findElement(By.tagName("Google"));
        String pageTitle = titleElement.getText();
        System.out.println("Page Title: " + pageTitle);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


