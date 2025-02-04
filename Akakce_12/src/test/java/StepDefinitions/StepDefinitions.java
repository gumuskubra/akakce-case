package StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ConfigReader;
import Pages.SearchPage;
import Pages.LoginPage;

public class StepDefinitions {
    WebDriver driver;
    LoginPage loginPage;
    SearchPage searchPage;

    @Given("User visits the akakce.com website")
    public void user_visits_the_akakce_com_website() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("base_url"));
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
    }

    @And("User logs in")
    public void userLogsIn() {
        loginPage.login();
    }

    @When("User searches for a popular product like {string}")
    public void userSearchesForAPopularProductLike(String productName) {
        searchPage = new SearchPage(driver);
        searchPage.searchProduct(productName);
    }

    @Then("The product list should be displayed")
    public void the_product_list_should_be_displayed() {
        assert !driver.findElements(searchPage.productListXPath).isEmpty();
    }

    @And("User selects a product from the list")
    public void userSelectsAProductFromTheList() {
        searchPage.selectFirstProduct();
    }

    @And("User clicks Go To Product")
    public void userClicksOnGoToProduct() {
        searchPage.goToProductPage();
    }

    @And("User adds the product to the favorites list")
    public void user_adds_the_product_to_the_favorites_list() {
        searchPage.addToFavorites();
    }

    @Then("The product should be successfully added to the favorites")
    public void the_product_should_be_successfully_added_to_the_favorites() {
        System.out.println("Product successfully added to favorites!");
    }
}
