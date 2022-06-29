package logoutTest;

import baseTest.BaseTest;
import org.testng.annotations.Test;
import pages.CreateAccPage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class UserLogout extends BaseTest {

    LoginPage loginPage;

    String name = "testuotojas3";
    String pswd = "pswd123";

    @Test(groups = "smoke")
    public void logoutUserPositive() {

        loginPage = new LoginPage(driver);

        loginPage.enterUsername(name);
        loginPage.enterPassword(pswd);
        loginPage.clickLogin();
        assertEquals(driver.getTitle(), "Skaičiuotuvas");
        loginPage.clickLogoutButton();

        String expectedMessage = "Sėkmingai atsijungėte";
        String originalMessage = loginPage.logoutMessage.getText();
        assertEquals(expectedMessage, originalMessage, "Messages differs");


    }
}
