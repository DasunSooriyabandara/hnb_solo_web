package Test_Scenarios;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import Objects.AddOutletPage;
import Objects.BaseTest;
import Objects.ClickMyOutletLink;
import Objects.GoogleSearchPage;
import Objects.LoginPage;
import Objects.MyOutletsPage;

public class TestMethodsGoogleSearch extends BaseTest {

    GoogleSearchPage googleSearchPage;
    LoginPage loginPage;

    @Test(priority = 1)
    public void searchAndClickDrawifyLink() throws InterruptedException {
        googleSearchPage = new GoogleSearchPage(getDriver());
        getDriver().get("https://solo-admin-sit.hnb.lk/");

        // Uncomment and modify if you need to search and click on Drawify link
        // googleSearchPage.searchGoogle("drawify");
        // googleSearchPage.clickDrawifyLink();

        // Assert based on expected content on the landing page (modify as needed)
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        String expectedContent = "transform a plain message into one that gets attention!";
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//text()[contains(., '" + expectedContent + "')]")));
        AssertJUnit.assertTrue(
                getDriver().findElement(By.xpath("//text()[contains(., '" + expectedContent + "')]")).isDisplayed());
    }

    @Test(priority = 2, testName = "SignInpageTitle")
    public void SignInPageTitle() {
        loginPage = new LoginPage(getDriver());
        String actualTitle = loginPage.getPageTitle();
        String expectedTitle = "Solo";
        AssertJUnit.assertEquals(actualTitle, expectedTitle, "Expected and Actual Titles Do Not Match");
    }

    @Test(priority = 3)
    public void verifyLoginPageTitle() {
        loginPage = new LoginPage(getDriver());

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pageTitle"))); // Replace with appropriate locator for login page title

        String actualTitle = loginPage.getPageTitle();
        String expectedTitle = "Solo";
        AssertJUnit.assertEquals(actualTitle, expectedTitle, "Page title does not match.");
    }

    @Test(priority = 4)
    public void finalLoginTest() {
        loginPage = new LoginPage(getDriver());
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("Think100%");
        loginPage.clickSignIn();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("someElementAfterLogin"))); // Replace with appropriate locator for an element that appears after login

        getDriver().navigate().refresh();
        String actualTitle = loginPage.getPageTitle();
        String expectedTitle = "Solo";
        AssertJUnit.assertEquals(actualTitle, expectedTitle, "Title is not equal");
        System.out.println("Final login test passed successfully.");
    }

    

    @Test(priority = 5)
    public void ClickMyOutletLink() {
        ClickMyOutletLink autlink = new ClickMyOutletLink(getDriver());
        autlink.navigateToMyOutletLink();
        
        String actualTitle = loginPage.getPageTitle();
        String expectedTitle = "Solo";
        AssertJUnit.assertEquals(actualTitle, expectedTitle, "Title is not equal");
        System.out.println("My outlet link title test passed successfully.");
        
    }
    
    @Test(priority = 6)
    public void ClickAddButton() {
    	MyOutletsPage outpage = new MyOutletsPage(getDriver());
    	outpage.ClickAddButton();
    	
    	String actualTitle = loginPage.getPageTitle();
        String expectedTitle = "Solo";
        AssertJUnit.assertEquals(actualTitle, expectedTitle, "Title is not equal");
        System.out.println("Add button page title test passed successfully.");
        
    }
    @Test(priority = 7)
    public void FillFOrm() throws InterruptedException {
    	AddOutletPage autpage = new AddOutletPage(getDriver());
    	autpage.FillTheForm();
    }
    
    }

   
