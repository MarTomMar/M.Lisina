package createUserTest;

import baseTest.BaseTest;
import org.testng.annotations.Test;
import pages.CreateAccPage;
import pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class CreateNewUser extends BaseTest {
    CreateAccPage createAccPage;
    LoginPage loginPage;

    String name = "test" + (int) (Math.random() * Integer.MAX_VALUE);
    String pswd = "pswd" + (int) (Math.random() * Integer.MAX_VALUE);
    String pswdConf = pswd;
    String pswdConfFail = "pswd123456";

    @Test(priority=1, groups = "smoke")
    public void registerNewUserPositive() {

        createAccPage = new CreateAccPage(driver);
        loginPage = new LoginPage(driver);

        loginPage.clickCreateAccount();
        createAccPage.enterUsername(name);
        createAccPage.enterPassword(pswd);
        createAccPage.confirmPassword(pswdConf);
        createAccPage.submitAcc();
        assertEquals(driver.getTitle(), "Skaičiuotuvas");
        loginPage.clickLogoutButton();

    }

    @Test (priority=2, groups = "smoke")
    public void registerNewUserNegative(){

        createAccPage = new CreateAccPage(driver);
        loginPage = new LoginPage(driver);

        loginPage.clickCreateAccount();
        createAccPage.enterUsername(name);
        createAccPage.enterPassword(pswd);
        createAccPage.confirmPassword(pswdConfFail);
        createAccPage.submitAcc();
        assertEquals(driver.getTitle(), "Registracija");

    }

}
