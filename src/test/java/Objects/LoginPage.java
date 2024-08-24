package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor to initialize WebDriver and WebDriverWait
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait time
    }

    // Locators
    By usernameField = By.id("login-username-field"); // Replace with the actual ID or locator for the username field
    By passwordField = By.id("login-password-field"); // Replace with the actual ID or locator for the password field
    By signInBtn = By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[2]/div[1]/div[1]/form[1]/button[1]/span[1]"); // Replace with the actual ID or locator for the sign-in button
    By errorMessage = By.xpath("//div[@class='error-message']"); // Locator for the error message if needed
    By addButton = By.xpath("//span[normalize-space()='Add']"); // Locator for the "Add" button

    // Method to enter the username
    public void enterUserName(String username) {
        WebElement userElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        userElement.clear();
        userElement.sendKeys(username);
    }

    // Method to enter the password
    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    // Method to click the sign-in button
    public void clickSignIn() {
        WebElement signInElement = wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
        signInElement.click();
    }

    // Method to click the "Add" button
    public void clickAddButton() {
        WebElement addBtnElement = wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addBtnElement.click();
    }

    // Method to get the page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Method to get the error message after a failed login attempt
    public String getErrorMessage() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return errorElement.getText();
    }

    // Method to clear the username and password fields
    public void clearFields() {
        WebElement userElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        userElement.clear();
        passwordElement.clear();
    }
}
