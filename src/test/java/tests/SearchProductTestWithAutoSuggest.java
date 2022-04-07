package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTestWithAutoSuggest extends ParallelTestBase{

    String ProductName = "Apple MacBook Pro 13-inch";
    SearchPage SearchObject;
    ProductDetailsPage ProductObject;

    @Test
    public void UserCanSearchForProductWithAutoSuggest()
    {
        try {
            SearchObject = new SearchPage(getDriver());
            ProductObject = new ProductDetailsPage(getDriver());
            SearchObject.ProductSearchUsingAutoSuggest("Mac");
            Assert.assertTrue(ProductObject.productNameBreadCrumb.getText().equalsIgnoreCase(ProductName));
        }
        catch (Exception e)
        {
            System.out.println("Error Occurred " + e.getMessage());
        }

    }
}
