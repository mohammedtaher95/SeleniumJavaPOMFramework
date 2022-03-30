package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

    HomePage HomeObject;
    ContactUsPage ContactObject;
    Faker faker = new Faker();

    String FullName = faker.name().fullName();
    String Email = faker.internet().emailAddress();
    String Message = faker.address().fullAddress();

    String SuccessMessage = "Your enquiry has been successfully sent to the store owner.";

    @Test
    public void UserCanContactWebsiteOwner()
    {
        HomeObject = new HomePage(driver);
        ContactObject = new ContactUsPage(driver);
        HomeObject.openContactUsPage();
        ContactObject.FillContactInfoForm(FullName, Email, Message);
        // wait.until(ExpectedConditions.textToBePresentInElement(ContactObject.successMessage, SuccessMessage));
        Assert.assertTrue(ContactObject.successMessage.getText().equalsIgnoreCase(SuccessMessage));
    }


}
