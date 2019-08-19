package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class abstractPage {
    private static WebDriver driver;

    protected void open(String url) {
        driver.get(url);
    }

    protected abstractPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    protected WebElement find(By locator) throws NotFoundException {
        WebElement Element = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    protected String getTextFromElement(By locator) {
        return find(locator).getText();
    }

    public static void close() {
        driver.close();
    }

    protected boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }
}
