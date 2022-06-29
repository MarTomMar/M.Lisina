package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitForJS;

public class CreateAccPage extends AbstractObjectPage{
    public CreateAccPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "passwordConfirm" )
    private WebElement passwordConfirmInput;

    @FindBy(className = "btn-primary")
    private WebElement buttonSubmit;

    public void enterUsername(String name) {
        username.sendKeys(name);
    }

    public void enterPassword(String pswd) {
        password.sendKeys(pswd);
    }

    public void confirmPassword(String pswdConf) {
        passwordConfirmInput.sendKeys(pswdConf);
    }

    public void submitAcc (){buttonSubmit.click(); WaitForJS.waitForJS(driver);}

}
