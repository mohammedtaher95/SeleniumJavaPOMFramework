package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddProductReviewTest extends ParallelTestBase{

    HomePage homeObject;
    UserRegistrationPage registerPage;
    SearchPage SearchObject;
    ProductDetailsPage ProductObject;
    ProductReviewPage ReviewObject;

    String ProductName = "Apple MacBook Pro 13-inch";
    String SuccessMessage = "Product review is successfully added.";

    UserFormData newUser = new UserFormData();

    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSuccessfully()
    {
        homeObject = new HomePage(getDriver());
        homeObject.openRegistrationPage();
        registerPage = new UserRegistrationPage(getDriver());
        registerPage.userRegistration(newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(), newUser.getOldPassword());
        Assert.assertTrue(registerPage.successMessage.getText().contains("Your registration completed"));
    }

    @Test(priority = 2, alwaysRun = true)
    public void UserCanSearchForProducts(){
        SearchObject = new SearchPage(getDriver());
        ProductObject = new ProductDetailsPage(getDriver());
        SearchObject.ProductSearch(ProductName);
        SearchObject.OpenProductPage();
        Assert.assertTrue(ProductObject.productNameBreadCrumb.getText().equalsIgnoreCase(ProductName));
    }

    @Test(priority = 3, alwaysRun = true)
    public void RegisteredUserCanAddReviewForProduct() {
        ReviewObject = new ProductReviewPage(getDriver());
        ProductObject.AddReview();
        ReviewObject.FillReviewForm(newUser.getMessage(),newUser.getMessage());
        Assert.assertTrue(ReviewObject.successMessage.getText().equalsIgnoreCase(SuccessMessage));
        Assert.assertTrue(ReviewObject.AddedReviewTitle.getText().equals(newUser.getMessage()));
    }

    @Test(priority = 4, alwaysRun = true)
    public void RegisteredUserCanLogout()
    {
        registerPage.userlogout();
    }
}
