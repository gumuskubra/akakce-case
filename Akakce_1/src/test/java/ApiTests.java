import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTests {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    // Create a Logger instance
    private static final Logger logger = LoggerFactory.getLogger(ApiTests.class);

    @BeforeEach
    public void setUp() {
        // This is executed before each test method
        logger.info("[ApiTests][setUp] Setting up test...");
    }

    @AfterEach
    public void tearDown() {
        // This is executed after each test method
        logger.info("[ApiTests][tearDown] Tearing down test...");
    }

    @Test
    public void shouldReturn200WhenCallingBaseUrl() {
        // API'yi çağırıyoruz ve status kodunu kontrol ediyoruz
        logger.info("[ApiTests][shouldReturn200WhenCallingBaseUrl] Starting the status code test...");
        given()
                .when()
                .get(BASE_URL)
                .then()
                .statusCode(200);  // 200 OK durum kodu bekliyoruz
        logger.info("[ApiTests][shouldReturn200WhenCallingBaseUrl] Test completed successfully.");
    }

    @Test
    public void shouldValidateJsonStructureForPosts() {
        // JSON yapısının doğruluğunu kontrol ediyoruz
        logger.info("[ApiTests][shouldValidateJsonStructureForPosts] Starting Json structure validation...");
        String url = BASE_URL + "/posts";
        given()
                .when()
                .get(url)
                .then()
                .assertThat()
                .body("$", is(not(empty())))  // JSON dizisi boş olmamalı
                .body("[0]", hasKey("userId"))  // userId key'i olmalı
                .body("[0]", hasKey("id"))      // id key'i olmalı
                .body("[0]", hasKey("title"))   // title key'i olmalı
                .body("[0]", hasKey("body"));   // body key'i olmalı
        logger.info("[ApiTests][shouldValidateJsonStructureForPosts] Test completed successfully.");
    }

    @Test
    public void shouldReturnCorrectTitleForPostWithId1() {
        // id'si 1 olan gönderinin title'ını kontrol ediyoruz
        logger.info("[ApiTests][shouldReturnCorrectTitleForPostWithId1] Starting Title control...");
        String url = BASE_URL + "/posts/1";
        given()
                .when()
                .get(url)
                .then()
                .assertThat()
                .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
        logger.info("[ApiTests][shouldReturnCorrectTitleForPostWithId1] Test completed successfully.");
    }

    @Test
    public void shouldValidatePostListLengthIsAtLeast10() {
        // JSON dizisinin uzunluğunun 10 veya daha fazla olduğunu kontrol ediyoruz
        logger.info("[ApiTests][shouldValidatePostListLengthIsAtLeast10] Starting POST lenght validation...");
        String url = BASE_URL + "/posts";
        given()
                .when()
                .get(url)
                .then()
                .assertThat()
                .body("size()", greaterThanOrEqualTo(10));  // Dizinin uzunluğu 10'dan büyük olmalı
        logger.info("[ApiTests][shouldValidatePostListLengthIsAtLeast10] Test completed successfully.");
    }

    @Test
    public void shouldValidateUserIdsArePositiveIntegers() {
        // userId'nin pozitif tamsayılar olduğunu kontrol ediyoruz
        logger.info("[ApiTests][shouldValidateUserIdsArePositiveIntegers] Starting User ID positive validation...");
        String url = BASE_URL + "/posts";
        given()
                .when()
                .get(url)
                .then()
                .assertThat()
                .body("userId", everyItem(greaterThan(0)));  // userId tüm öğeler için pozitif olmalı
        logger.info("[ApiTests][shouldValidateUserIdsArePositiveIntegers] Test completed successfully.");
    }
}
