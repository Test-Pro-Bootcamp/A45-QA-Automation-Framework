import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework15 extends BaseTest {
    @Test
    public void hw15 (){
        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://testpro.io/");
    }
}
