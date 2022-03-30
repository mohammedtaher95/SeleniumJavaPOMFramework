package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends PageBase {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "small-searchterms")
    WebElement SearchField;

    @FindBy(css = "button.button-1.search-box-button")
    WebElement SearchButton;

    @FindBy(id = "ui-id-1")
    List<WebElement> ProductList;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("strong.current-item")));
    }

    public void ProductSearchUsingAutoSuggest(String SearchText)
    {
        Fill_in_Text(SearchField, SearchText);
        wait.until(ExpectedConditions.elementToBeClickable((By) ProductList));
        ProductList.get(0).click();
    }
}
