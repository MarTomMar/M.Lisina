package loginTest;

import baseTest.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.CreateAccPage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class UserLogin extends BaseTest {

    CreateAccPage createAccPage;
    LoginPage loginPage;

    String name = "testuotojas3";
    String pswd = "pswd123";
    String pswdConf = pswd;
    String incorrectPswd = "123pswd";

    @Test(priority=1, groups = "smoke")
    public void loginUserPositive() {

        createAccPage = new CreateAccPage(driver);
        loginPage = new LoginPage(driver);

        loginPage.clickCreateAccount();
        createAccPage.enterUsername(name);
        createAccPage.enterPassword(pswd);
        createAccPage.confirmPassword(pswdConf);
        createAccPage.submitAcc();
        assertEquals(driver.getTitle(), "Skaičiuotuvas");
        loginPage.clickLogoutButton();
        loginPage.enterUsername(name);
        loginPage.enterPassword(pswd);
        loginPage.clickLogin();
        assertEquals(driver.getTitle(), "Skaičiuotuvas");
        loginPage.clickLogoutButton();

    }

    @Test(priority=2, groups = "smoke")
    public void loginUserNegative(){
        createAccPage = new CreateAccPage(driver);
        loginPage = new LoginPage(driver);

        loginPage.clickCreateAccount();
        createAccPage.enterUsername(name);
        createAccPage.enterPassword(pswd);
        createAccPage.confirmPassword(pswdConf);
        createAccPage.submitAcc();
        assertEquals(driver.getTitle(), "Skaičiuotuvas");
        loginPage.clickLogoutButton();
        loginPage.enterUsername(name);
        loginPage.enterPassword(incorrectPswd);
        loginPage.clickLogin();

        String expectedMessage = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";
        String originalMessage = loginPage.errorMessage.getText();
        assertEquals(expectedMessage, originalMessage, "Messages differs");

    }
}
