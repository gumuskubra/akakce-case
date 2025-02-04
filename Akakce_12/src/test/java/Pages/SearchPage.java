package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;


public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Son sürüm için Duration parametresi
    }

    // Web Elements
    private By searchBoxXPath = By.xpath("/html/body/div[1]/header/div[3]/form/span/input"); // search box
    private By searchButtonXPath = By.xpath("/html/body/div[1]/header/div[3]/form/button"); // search button
    public By productListXPath = By.xpath("/html/body/div[2]/ul"); // product list
//    private By goToProductXPath = By.xpath("/html/body/div[2]/ul/li[1]/a/span/span[6]/b");
    private By goToProductXPath = By.xpath("//span[contains(text(), 'Ürüne Git')]");
    private By addToFavoritesXPath = By.xpath("//span[@class='ufo_v8' and contains(text(), 'Takip Et')]"); // follow button

    // Methods
    public void searchProduct(String productName) {
        wait.until(ExpectedConditions.elementToBeClickable(searchBoxXPath)); // Bekleme eklenmeli
        driver.findElement(searchBoxXPath).sendKeys(productName);
        driver.findElement(searchButtonXPath).click();
    }

    public void selectFirstProduct() {
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productListXPath));
        if (!products.isEmpty()) {
            products.get(0).click(); // get(0) kullanıldı
        }
    }
    public void goToProductPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(goToProductXPath));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(goToProductXPath));
        element.click();
    }


    public void addToFavorites() {
        wait.until(ExpectedConditions.elementToBeClickable(addToFavoritesXPath)); // Bekleme eklenmeli
        driver.findElement(addToFavoritesXPath).click();
    }
}
