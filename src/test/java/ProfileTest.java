import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest{
    @Test
    public void changeProfileName()throws InterruptedException{
        String newName = getRandomString();

        provideTestEmail();
        provideTestPassword();
        logInButton();

        openUserProfilePage();
        setCurrentPassword();
        setNewName(newName);
        saveProfile();


        WebElement newProfileName = driver.findElement(By.xpath("//span[@class='name']"));
        Thread.sleep(2000);
        Assert.assertEquals(newProfileName.getText(), newName);
    }
}
