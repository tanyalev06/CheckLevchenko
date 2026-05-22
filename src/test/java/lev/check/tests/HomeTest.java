package lev.check.tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeTest {

    private static final Logger logger = LoggerFactory.getLogger(HomeTest.class);

    @Test
    @Story("Проверка копирайта")
    @Description("Проверка копирайта в футере сайта")
    public void testCheckCopiwrite() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Allure.step("Открыть домашнюю страницу сайта", () -> {
            String url = "https://www.check24.de/";
            logger.info("Переход по адресу {}", url);

            driver.navigate().to(url);
            Thread.sleep(2000);
        });

        Allure.step("Проверить текст копирайта в футере сайта", () -> {
            logger.info("Поиск элемента копирайта в футере");
            String c24footerCompaniLineXpath = "//div[@class='c24-footer-company-line']";
            WebElement c24footerCompanyLine = driver.findElement(By.xpath(c24footerCompaniLineXpath));

            String c24footerText = c24footerCompanyLine.getText();
            logger.info("Текст копирайта в футере {}", c24footerText);

            assertThat(c24footerText).isEqualTo("© 2026 CHECK24 Vergleichsportal GmbH München");
            logger.info("Проверка успешна");
        });
        driver.quit();
    }
}
