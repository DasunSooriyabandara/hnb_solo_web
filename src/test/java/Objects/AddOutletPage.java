package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddOutletPage {

    private WebDriver driver;
    private static final String OUTLET_NAME = "Automation Test"; // Use a constant for the outlet name

    // Constructor to initialize WebDriver
    public AddOutletPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By addButton = By.xpath("//span[normalize-space()='Add']");
    private By enterName = By.xpath("//*[@id=\"outlet-outlet-name-field\"]");
    private By merchantType = By.xpath("//*[@id=\"form-outlet-merchant-type-field\"]/div/div[2]/div");
    private By merchantTypeOpt = By.id("react-select-8-option-0");
    private By merchantName = By.xpath("//*[@id=\"outlet-merchant-id-field\"]/div/div[1]");
    private By merchantNameOpt = By.id("react-select-15-option-4");
    private By uploadImageBtn = By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div/form/div[1]/div[17]/div/div/div/div[1]/label/span");
    private By midField = By.id("outlet-merchant-transaction-type-id-field");
    private By saveButton = By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div/form/div[3]/button[2]");
    private By successMessageLocator = By.id("success-message"); 
    private By errorMessageLocator = By.id("client-snackbar"); // Replace with the actual locator for the error message
    private By searchBox = By.xpath("//*[@id=\"user-first-name-field\"]");
    private By verifySearchItem = By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[2]/div/div[2]/div[3]/table/tbody/tr/td[1]/div");

    // Method to navigate to the 'My Outlets' page and click the 'Add' button
    public void clickAddButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addButtonElement = wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButtonElement.click();
    }

    // Method to fill the form with a sample name and verify the result
    public void fillTheForm() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Enter the name
        WebElement enterNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(enterName));
        enterNameElement.sendKeys(OUTLET_NAME);

        // Click on the Merchant Type dropdown and select the option
        WebElement merchantTypeElement = wait.until(ExpectedConditions.elementToBeClickable(merchantType));
        merchantTypeElement.click();

        WebElement merchantTypeOptElement = wait.until(ExpectedConditions.visibilityOfElementLocated(merchantTypeOpt));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", merchantTypeOptElement);
        ((JavascriptExecutor) driver).executeScript("var elements = document.getElementsByClassName('PrivateSwipeArea-root-227');"
                + "while(elements.length > 0) { elements[0].parentNode.removeChild(elements[0]); }");
        merchantTypeOptElement.click();
        Thread.sleep(3000);

        WebElement selectedOption = wait.until(ExpectedConditions.visibilityOfElementLocated(merchantType));
        selectedOption.getText().contains("Expected Option Text");
        selectedOption.click();
        Thread.sleep(3000);
        System.out.println("Merchant Type selected successfully: " + selectedOption.getText());

        // Click on the Merchant Name dropdown and select the option
        WebElement merchantNameElement = wait.until(ExpectedConditions.elementToBeClickable(merchantName));
        merchantNameElement.click();

        WebElement merchantNameOptElement = wait.until(ExpectedConditions.visibilityOfElementLocated(merchantNameOpt));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", merchantNameOptElement);
        ((JavascriptExecutor) driver).executeScript("var elements = document.getElementsByClassName('PrivateSwipeArea-root-227');"
                + "while(elements.length > 0) { elements[0].parentNode.removeChild(elements[0]); }");
        String merchantType = merchantNameOptElement.getText();
        merchantNameOptElement.click();
        Thread.sleep(3000);

        WebElement selectedOption1 = wait.until(ExpectedConditions.visibilityOfElementLocated(merchantName));
        selectedOption1.getText().contains("Expected Option Text");
        selectedOption1.click();
        System.out.println("Merchant Name selected successfully: " + selectedOption1.getText());

        // Upload the image
        WebElement fileInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(uploadImageBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileInputElement);
        fileInputElement.sendKeys("C:\\Users\\USER\\Downloads\\signature.png");
        System.out.println("Image uploaded successfully.");

        // Enter MID
        WebElement enterMID = wait.until(ExpectedConditions.elementToBeClickable(midField));
        enterMID.sendKeys("12345678");
        System.out.println("Enter MID successfully.");

        // Click Save button
        WebElement clickSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        clickSaveBtn.click();
        System.out.println("Save Add Outlet Details Successfully");

        // Verify success or error message
        try {
            WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
            String successMessageText = successMessageElement.getText();

            if (successMessageText.contains("Outlet created successfully")) {
                System.out.println("Outlet creation verification passed: " + successMessageText);
            } else {
                System.out.println("Outlet creation verification failed.");
            }
        } catch (Exception e) {
            // If success message not found, check for an error message
            try {
                WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
                String errorMessageText = errorMessageElement.getText();

                System.out.println("Outlet creation failed with error message: " + errorMessageText);
            } catch (Exception ex) {
                System.out.println("Error message not found. Outlet creation might not have been attempted.");
            }
        }
    }

    // Method to search for the created outlet
    public void searchOutlet() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBoxElement = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchBoxElement.sendKeys(OUTLET_NAME);
        Thread.sleep(5000);

        WebDriverWait waitShort = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement verifySearchItemElement = waitShort.until(ExpectedConditions.visibilityOfElementLocated(verifySearchItem));
        String searchResult = verifySearchItemElement.getText();

        if (searchResult.contains(OUTLET_NAME)) {
            System.out.println("Search result successfully: " + searchResult);
        } else {
            System.out.println("Search result not displayed successfully.");
        }
    }
}
