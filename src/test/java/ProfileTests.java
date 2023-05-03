import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test
    public static void changeProfileNameTest () {

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        clickAvatarIcon();

        String randomName = generateRandomName();

        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.name")));
        WebElement actualProfileName = driver.findElement(By.cssSelector("span.name"));
        Assert.assertEquals(actualProfileName.getText(), randomName);
    }
}
