package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends PageBase{

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FullName")
    private WebElement NameField;

    @FindBy(id = "Email")
    private WebElement EmailField;

    @FindBy(id = "Enquiry")
    WebElement EnquiryField;

    @FindBy(css = "button.button-1.contact-us-button")
    WebElement SubmitBtn;

    @FindBy(css = "div.result")
    public WebElement successMessage;


    public void FillContactInfoForm(String Name, String Email, String Enquiry)
    {
        Fill_in_Text(NameField, Name);
        Fill_in_Text(EmailField, Email);
        Fill_in_Text(EnquiryField, Enquiry);
        ClickButton(SubmitBtn);
        wait.until(ExpectedConditions.visibilityOf(successMessage));
    }
}
