package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

    public ProductReviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "AddProductReview_Title")
    private WebElement ReviewTitleField;

    @FindBy(id = "AddProductReview_ReviewText")
    private WebElement ReviewTextField;

    @FindBy(id = "addproductrating_4")
    WebElement RatingRadioBtn;

    @FindBy(css = "button.button-1.write-product-review-button")
    WebElement SubmitBtn;

    @FindBy(css = "div.result")
    public WebElement successMessage;

    @FindBy(css = "div.review-title")
    public WebElement AddedReviewTitle;

    public void FillReviewForm(String ReviewTitle, String ReviewText)
    {
        Fill_in_Text(ReviewTitleField, ReviewTitle);
        Fill_in_Text(ReviewTextField, ReviewText);
        ClickButton(RatingRadioBtn);
        ClickButton(SubmitBtn);
    }
}
