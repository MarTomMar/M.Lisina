package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractObjectPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(className = "btn-primary")
    public WebElement buttonLogin;

    @FindBy(linkText = "Sukurti naują paskyrą")
    private WebElement buttonCreateAccount;

    @FindBy(xpath = "/html/body/nav/div/ul[2]/a")
    private WebElement buttonLogout;

    @FindBy(css = "body > div > form > div > span:nth-child(4)")
    public WebElement errorMessage;

    @FindBy(css = "body > div > form > div > span:nth-child(1)")
    public WebElement logoutMessage;

    public void enterUsername(String name) {
        username.sendKeys(name);
    }

    public void enterPassword(String pswd) {
        password.sendKeys(pswd);
    }

    public void clickLogin() {
        buttonLogin.click();
    }

    public void clickCreateAccount() {
        buttonCreateAccount.click();
    }

    public void clickLogoutButton(){buttonLogout.click();}

}
