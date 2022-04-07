package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends ParallelTestBase{

    HomePage homeObject;
    SearchPage SearchObject;
    ProductDetailsPage ProductObject;

    @Test(priority = 1, alwaysRun = true)
    public void UserCanChangeCurrency()
    {
        homeObject = new HomePage(getDriver());
        homeObject.changeCurrency(1);
    }

    @Test(priority = 2, alwaysRun = true)
    public void UserCanSearchForProductWithAutoSuggest()
    {
        try {
            SearchObject = new SearchPage(getDriver());
            ProductObject = new ProductDetailsPage(getDriver());
            SearchObject.ProductSearchUsingAutoSuggest("Mac");
            Assert.assertTrue(ProductObject.ProductPriceLabel.getText().contains("€"));
        }
        catch (Exception e)
        {
            System.out.println("Error Occurred " + e.getMessage());
        }

    }
}
