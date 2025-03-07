package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    private static WebDriver driver;

    // Private constructor to prevent instantiation
    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver; // Eğer driver zaten başlatıldıysa, tekrar başlatmıyoruz.
        }

        try {
            String browser = ConfigReader.getProperty("browser");
            if (browser == null || browser.trim().isEmpty()) {
                browser = "chrome"; // Varsayılan olarak Chrome kullanıyoruz
            }
            System.out.println("Browser: " + browser);

            switch (browser.toLowerCase().trim()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    System.out.println("Chrome başlatılıyor...");
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
            }

            driver.manage().window().maximize();  // Pencereyi büyütme
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            System.out.println("Driver başarıyla başlatıldı!");
        } catch (Exception e) {
            System.err.println("Driver başlatılırken hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }


        return driver;
    }}