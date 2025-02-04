package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Web Elements
    private final By loginButton = By.xpath("/html/body/div[1]/header/div[2]/div[1]/a[2]"); // homepage login button
    private final By emailField = By.id("life"); // email input
    private final By passwordField = By.id("lifp"); // password input
    private final By submitButton = By.id("lfb"); // login button

    // Methods
    public void login() {
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(ConfigReader.getProperty("username"));
        driver.findElement(passwordField).sendKeys(ConfigReader.getProperty("password"));
        driver.findElement(submitButton).click();
    }
}
