package lev.check;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OzonHeaderTest {
    private WebDriver driver;
    private OzonHeaderPage headerPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        headerPage = new OzonHeaderPage(driver);
    }

    @Test
    public void testHeaderTabsNavigation() throws InterruptedException {
        headerPage.openHomePage();

        headerPage.clickLogin();
        Thread.sleep(1500);

        headerPage.clickOrders();
        Thread.sleep(1500);
        assertTrue(driver.getCurrentUrl().contains("login") || driver.getCurrentUrl().contains("order"),
                "Ошибка перехода на страницу авторизации или заказов");

        headerPage.clickFavorites();
        Thread.sleep(1500);
        assertTrue(driver.getCurrentUrl().contains("favorites") || driver.getCurrentUrl().contains("login"),
                "Ошибка перехода в избранное");

        headerPage.clickCart();
        Thread.sleep(1500);
        assertTrue(driver.getCurrentUrl().contains("cart"),
                "Ошибка перехода в корзину");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}