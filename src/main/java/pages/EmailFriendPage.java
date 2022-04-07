package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{

    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FriendEmail")
    private WebElement FriendEmailField;

    @FindBy(id = "YourEmailAddress")
    private WebElement YourEmailField;

    @FindBy(id = "PersonalMessage")
    WebElement MessageField;

    @FindBy(css = "button.button-1.send-email-a-friend-button")
    WebElement SendBtn;

    @FindBy(css = "div.result")
    public WebElement successMessage;


    public void FillEmailFriendForm(String FriendEmail, String Message) {
        Fill_in_Text(FriendEmailField, FriendEmail);
        Fill_in_Text(MessageField,Message);
        ClickButton(SendBtn);
    }


}
