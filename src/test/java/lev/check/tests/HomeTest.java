package lev.check.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeTest {
    @Test
    public void testCheckCopiwrite() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String url = "https://www.check24.de/";
        driver.navigate().to(url);
        Thread.sleep(2000);

        String c24footerCompaniLine = "//*[@id=\"c24-footer\"]/div[2]/div[1]/div[1]";
        WebElement c24footerCompanyLineByXpath = driver.findElement(By.xpath(c24footerCompaniLine));
        String c24footerText = c24footerCompanyLineByXpath.getText();

        Assertions.assertEquals("© 2026 CHECK24 Vergleichsportal GmbH München", c24footerText);

        driver.quit();
    }
}
