package okdesk.pages;

import okdesk.core.BaseSeleniumPage;
import okdesk.readProperties.ConfigProvider;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseSeleniumPage {

    @FindBy(id = "user_login")
    private WebElement userLogin;

    @FindBy(id="user_password")
    private WebElement userPassword;

    @FindBy(xpath = "//label[@for=\"user_remember_me\"]/preceding-sibling::div")
    private WebElement userRememberMe;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//div[@data-role=\"flash-container\"]//span")
    private WebElement errorAuth;

    public LoginPage(){

        webDriver.get(ConfigProvider.URL);
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage typeLogin(String loginValue){

        userLogin.sendKeys(loginValue);
        return this;
    }

    public LoginPage typePassword(String passwordValue){

        userPassword.sendKeys(passwordValue);
        return this;
    }

    public LoginPage clickCheckBox(boolean value){

        if(!userRememberMe.isSelected() == value){
            userRememberMe.click();
        }

        return this;
    }

    public MainPage clickSubmitButton(){

        buttonSubmit.submit();

        return new MainPage();
    }

    public MainPage checkAuth(String loginValue, String passwordValue, boolean value){

        typeLogin(loginValue);
        typePassword(passwordValue);
        clickCheckBox(value);
        clickSubmitButton();
        return new MainPage();
    }

    public String getErrorAuth(){

        return errorAuth.getText();
    }
}
