package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor: WebDriver nesnesini parametre olarak alır
    public SearchPage(WebDriver driver) {
        this.driver = driver;  // WebDriver'ı parametre olarak alıyoruz
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // WebDriver'ı kullanarak WebDriverWait oluşturuyoruz
    }

    // Web Elemanları
    private By searchBox = By.xpath("/html/body/div[1]/header/div[3]/form/span/input"); // Arama kutusu
    private By searchButton = By.xpath("/html/body/div[1]/header/div[3]/form/button"); // Arama butonu
    public By productListXPath = By.xpath("/html/body/div[2]/ul"); // Ürün listesi
    private By goToProductButton = By.xpath("//span[contains(text(), 'Ürüne Git')]"); // Ürüne git butonu
    private By addToFavoritesButton = By.xpath("//span[@class='ufo_v8' and contains(text(), 'Takip Et')]"); // Favorilere ekle butonu
    private By acceptCookiesButton = By.xpath("//div[@id='59e066d1-086d-4238-a9a7-b31ba072937c' and @data-name='kabul et']");
    // XPath: "Takip Et" metnini içeren butonu seç


    // Çerezleri kabul etme fonksiyonu
    public void acceptCookies() {
        try {
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
            acceptButton.click();
            System.out.println("Çerez kabul butonuna tıklanmış oldu.");
        } catch (Exception e) {
            System.out.println("Çerez kabul butonu bulunamadı veya zaten tıklanmış olabilir: " + e.getMessage());
        }
    }

    // Ürün arama fonksiyonu
    public void searchProduct(String productName) {
        wait.until(ExpectedConditions.elementToBeClickable(searchBox)); // Arama kutusunun tıklanabilir olmasını bekle
        driver.findElement(searchBox).sendKeys(productName); // Arama kutusuna ürün ismini yaz
        driver.findElement(searchButton).click(); // Arama butonuna tıkla
    }

    // İlk ürünü seçme fonksiyonu
    public void selectFirstProduct() {
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productListXPath));
        if (!products.isEmpty()) {
            products.get(0).click(); // İlk ürüne tıkla
        }
    }

    // Ürün sayfasına gitme fonksiyonu
    public void goToProductPage() {
        String originalWindow = driver.getWindowHandle(); // Mevcut sekmeyi sakla

        try {
            WebElement goToProductBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(goToProductButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", goToProductBtn);
            goToProductBtn.click();

            // Yeni sekmeye geçiş
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle); // Yeni sekmeye geçiş
                    break;
                }
            }

            // Yeni sayfanın tamamen yüklenmesini bekle
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            System.err.println("Ürün sayfasına gitme sırasında hata: " + e.getMessage());
        }
    }

    public void addToFavorites() {
        // Çerez kabul etme işlemini çağırıyoruz
        acceptCookies();

        try {
            // Dinamik öğe varsa gizlenmesini bekle
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//efilli-layout-dynamic")));
        } catch (Exception e) {
            System.out.println("Dinamik öğe gizlenemedi: " + e.getMessage());
        }

        try {

            Actions actions = new Actions(driver);
            WebElement followButton = wait.until(ExpectedConditions.elementToBeClickable(addToFavoritesButton));

// Çift tıklama
            actions.moveToElement(followButton).doubleClick().perform();

            System.out.println("Takip Et butonuna tıklanmış oldu.");
        } catch (Exception e) {
            System.out.println("Takip Et butonuna tıklanırken hata: " + e.getMessage());
        }
    }

}
