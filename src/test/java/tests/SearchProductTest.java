package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase{

    String ProductName = "Apple MacBook Pro 13-inch";
    SearchPage SearchObject;
    ProductDetailsPage ProductObject;

    @Test
    public void UserCanSearchForProducts()
    {
        SearchObject = new SearchPage(driver);
        ProductObject = new ProductDetailsPage(driver);
        SearchObject.ProductSearch(ProductName);
        SearchObject.OpenProductPage();
        Assert.assertTrue(ProductObject.productNameBreadCrumb.getText().equalsIgnoreCase(ProductName));
    }
}
