import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework16 {

    @Test
    public void registrationNavigation() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://bbb.testpro.io/");

        WebElement registrationLink = driver.findElement(By.linkText("Registration"));
        registrationLink.click();

        Assertions.assertEquals("https://bbb.testpro.io/register", driver.getCurrentUrl());
    }
}
