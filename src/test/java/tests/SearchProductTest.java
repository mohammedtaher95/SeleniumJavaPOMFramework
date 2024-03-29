package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends ParallelTestBase{

    String ProductName = "Apple MacBook Pro 13-inch";
    SearchPage SearchObject;
    ProductDetailsPage ProductObject;

    @Test
    public void UserCanSearchForProducts() {
        SearchObject = new SearchPage(getDriver());
        ProductObject = new ProductDetailsPage(getDriver());
        SearchObject.ProductSearch(ProductName);
        SearchObject.OpenProductPage();
        Assert.assertTrue(ProductObject.productNameBreadCrumb.getText().equalsIgnoreCase(ProductName));
    }
}
