package Test_Scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import Objects.AddOutletPage;
import Objects.BaseTest;
import Objects.ClickMyOutletLink;
import Objects.FilterOutlet;
import Objects.GoogleSearchPage;
import Objects.LoginPage;
import Objects.MyOutletsPage;

public class TestMethodsGoogleSearch extends BaseTest {

    GoogleSearchPage googleSearchPage;
    LoginPage loginPage;

    @Test(priority = 1, testName = "Search URL and Open Web")
    public void searchAndClickHNBLink() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        
        googleSearchPage = new GoogleSearchPage(getDriver());
        getDriver().get("https://solo-admin-sit.hnb.lk/");
        System.out.println("Successfully loaded URL");

        // Assert URL load success
        String currentURL = getDriver().getCurrentUrl();
        softAssert.assertEquals(currentURL, "https://solo-admin-sit.hnb.lk/", "URL mismatch");

        softAssert.assertAll();
    }

    @Test(priority = 2, testName = "SignInPageTitle")
    public void SignInPageTitle() {
        SoftAssert softAssert = new SoftAssert();
        
        loginPage = new LoginPage(getDriver());
        String actualTitle = loginPage.getPageTitle();
        System.out.println("Login page title : " + actualTitle);

        // Assert the title
        String expectedTitle = "Solo";
        softAssert.assertEquals(actualTitle, expectedTitle, "Expected and Actual Titles Do Not Match");

        softAssert.assertAll();
    }

    @Test(priority = 3, testName = "Login Page Title")
    public void verifyLoginPageTitle() {
        SoftAssert softAssert = new SoftAssert();
        
        loginPage = new LoginPage(getDriver());
        String actualTitle = loginPage.getPageTitle();
        String expectedTitle = "Solo";

        // Assert the page title matches the expected
        softAssert.assertEquals(actualTitle, expectedTitle, "Page title does not match.");

        softAssert.assertAll();
    }

    @Test(priority = 4, testName = "Login to the system")
    public void finalLoginTest() {
        SoftAssert softAssert = new SoftAssert();
        
        loginPage = new LoginPage(getDriver());
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("Think100%");
        loginPage.clickSignIn();

        // Assert successful login by checking for a post-login element
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        WebElement postLoginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("someElementAfterLogin"))); // Replace with the actual locator
//        softAssert.assertTrue(postLoginElement.isDisplayed(), "Post-login element not found");

        System.out.println("Successfully Login to the System");
        String actualTitle = loginPage.getPageTitle();
        String expectedTitle = "Solo";

        // Assert the title after login
        softAssert.assertEquals(actualTitle, expectedTitle, "Title is not equal");

        softAssert.assertAll();
    }

    @Test(priority = 5, testName = "Click My Outlet Link")
    public void ClickMyOutletLink() {
        SoftAssert softAssert = new SoftAssert();
        
        ClickMyOutletLink autlink = new ClickMyOutletLink(getDriver());
        autlink.navigateToMyOutletLink();
        
        System.out.println("Successfully Clicked the My Outlet Link");

        // Assert that we are on the correct page after clicking
        String actualTitle = getDriver().getTitle();
        String expectedTitle = "Solo";
        softAssert.assertEquals(actualTitle, expectedTitle, "Title is not equal");

        System.out.println("My outlet link title test passed successfully.");
        
        softAssert.assertAll();
    }

    @Test(priority = 6, testName = "Filter existing Outlet")
    public void filteringOutlet() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        
        FilterOutlet filter = new FilterOutlet(getDriver());
        filter.clickFilterButton();

        // Assert filter operation (you can validate by checking the filtered results)
        WebElement filteredResult = getDriver().findElement(By.id("filteredResult")); // Modify with actual element locator
        softAssert.assertTrue(filteredResult.isDisplayed(), "Filtered result not displayed");

        softAssert.assertAll();
    }

    @Test(priority = 7, testName = "Click Add Button")
    public void ClickAddButton() {
        SoftAssert softAssert = new SoftAssert();
        
        MyOutletsPage outpage = new MyOutletsPage(getDriver());
        outpage.ClickAddButton();
        
        String actualTitle = getDriver().getTitle();
        String expectedTitle = "Solo";
        
        // Assert page title after clicking add button
        softAssert.assertEquals(actualTitle, expectedTitle, "Title is not equal");
        System.out.println("Add button page title test passed successfully.");
        
        softAssert.assertAll();
    }

    @Test(priority = 8, testName = "Fill the form to add New Outlet")
    public void FillForm() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        
        AddOutletPage autpage = new AddOutletPage(getDriver());
        autpage.fillTheForm();

        // Assert form submission success (you can assert based on a success message or redirection)
        WebElement successMessage = getDriver().findElement(By.id("successMessage")); // Replace with the actual locator
        softAssert.assertTrue(successMessage.isDisplayed(), "Form submission success message not displayed");

        softAssert.assertAll();
    }

    @Test(priority = 9, testName = "Search for newly created Outlet")
    public void SearchCreateOutlet() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        
        AddOutletPage aop = new AddOutletPage(getDriver());
        aop.searchOutlet();

        // Assert that the newly created outlet appears in search results
        WebElement outletSearchResult = getDriver().findElement(By.id("outletSearchResult")); // Replace with the actual locator
        softAssert.assertTrue(outletSearchResult.isDisplayed(), "Newly created outlet not found in search results");

        softAssert.assertAll();
    }
}
