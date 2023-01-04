package okdesk;

import com.sun.tools.javac.Main;
import okdesk.core.BaseSeleniumTest;
import okdesk.helpers.TestValues;
import okdesk.pages.MainPage;
import okdesk.readProperties.ConfigProvider;
import org.junit.Assert;
import org.junit.Test;
import okdesk.pages.LoginPage;

public class LoginPageTest extends BaseSeleniumTest {

    private LoginPage loginPage;

    @Test
    public void loginWithValidCreds(){

       loginPage = new LoginPage();
       loginPage.checkAuth(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD, true);

       Assert.assertTrue(new MainPage().getTickets().size() > 0);
    }

    @Test
    public void loginWithInvalidCreds(){

        loginPage = new LoginPage();
        loginPage.checkAuth(ConfigProvider.USER_LOGIN, ConfigProvider.USER_PASSWORD, false);

        Assert.assertEquals(TestValues.ERROR_AUTH, loginPage.getErrorAuth());
    }
}
