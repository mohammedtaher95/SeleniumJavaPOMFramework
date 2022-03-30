package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "small-searchterms")
    WebElement SearchField;

    @FindBy(css = "button.button-1.search-box-button")
    WebElement SearchButton;

    @FindBy(id = "ui-id-1")
    WebElement SearchItem;

    @FindBy(css = "h2.product-title")
    WebElement ProductResult;

    public void ProductSearch(String ProductName)
    {
        Fill_in_Text(SearchField, ProductName);
        ClickButton(SearchButton);
    }

    public void OpenProductPage()
    {
        ClickButton(ProductResult);
    }
}
