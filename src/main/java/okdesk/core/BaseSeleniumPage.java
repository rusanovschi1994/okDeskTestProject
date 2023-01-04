package okdesk.core;

import org.openqa.selenium.WebDriver;

public abstract class BaseSeleniumPage {

    protected static WebDriver webDriver;

    public static void setDriver(WebDriver driver){
        webDriver = driver;
    }
}
