import PageFactory.HomePage;
import PageFactory.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWorkTest23 extends BaseTest {
    @Test
    public void loginEmptyEmailPasswordTest(){

        LoginPage loginPage=new LoginPage(driver);
        loginPage.provideEmail("").providePassword("te$t$tudent").clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
  @Test
    public void loginValidEmailPasswordTest(){
        LoginPage loginPage=new LoginPage(driver);
        HomePage homePage=new HomePage(driver);
        loginPage.provideEmail("mengi.gebremedhin@testpro.io")
                .providePassword("te$t$tudent").clickSubmit();
    }
    @Test
    public void loginEmailEmptyPasswordTest(){

        LoginPage loginPage=new LoginPage(driver);

        loginPage.provideEmail("mengi.gebremedhin@testpro.io").providePassword("").clickSubmit();
    }
}
