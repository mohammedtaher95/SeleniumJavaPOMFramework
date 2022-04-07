package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends PageBase {

    public SearchPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
    }

    @FindBy(id = "small-searchterms")
    WebElement SearchField;

    @FindBy(css = "button.button-1.search-box-button")
    WebElement SearchButton;

    @FindBy(id = "ui-id-1")
    List<WebElement> ProductList;

    @FindBy(css = "div.picture")
    WebElement ProductResult;

    public void ProductSearch(String ProductName)
    {
        Fill_in_Text(SearchField, ProductName);
        ClickButton(SearchButton);
    }

    public void OpenProductPage() {
        ClickButton(ProductResult);
    }

    public void ProductSearchUsingAutoSuggest(String SearchText)
    {
        Fill_in_Text(SearchField, SearchText);
        ProductList.get(0).click();
    }
}
