package lev.check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OzonHeaderPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By loginBtn = By.xpath("//div[contains(text(), 'Войти')]");
    private final By ordersBtn = By.xpath("//a[contains(@href, '/my/orderlist') or contains(@href, '/user/orders')]");
    private final By favoritesBtn = By.xpath("//a[contains(@href, '/my/favorites') or contains(@href, '/user/favorites')]");
    private final By cartBtn = By.xpath("//a[contains(@href, '/cart')]");

    public OzonHeaderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openHomePage() {
        driver.get("https://ozon.ru");
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public void clickOrders() {
        wait.until(ExpectedConditions.elementToBeClickable(ordersBtn)).click();
    }

    public void clickFavorites() {
        wait.until(ExpectedConditions.elementToBeClickable(favoritesBtn)).click();
    }

    public void clickCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartBtn)).click();
    }
}