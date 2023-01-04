package okdesk.pages;

import okdesk.core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//div[@class=\"header-toolbar\"]/a[@href=\"/issues/create_forms/new\"]")
    private WebElement newTicketButton;

    @FindBy(xpath = "//div[@class=\"sc-jtggT iacrQb\"]//table[@class=\"sc-iqzUVk kSXVHb\"]/tbody/tr")
    private List<WebElement> ticketsList;

    @FindBy(id = "search")
    private WebElement ticketSearchField;

    @FindBy(id ="issue_title")
    private WebElement newTicketTitle;

    @FindBy(xpath = "//label[normalize-space(text())='Тип заявки']/parent::div/following-sibling::div")
    private WebElement newTicketDropDownType;


    public MainPage(){

        PageFactory.initElements(webDriver, this);
    }

    public List<WebElement> getTickets(){

        return ticketsList;
    }

    public MainPage clickNewTicketButton(){

        newTicketButton.click();
        return this;
    }


}
