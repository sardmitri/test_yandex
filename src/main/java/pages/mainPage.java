package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

public class mainPage extends abstractPage {
    private static final String URL = "https://yandex.ru/";
    private final By searchInput = By.xpath("//*[@id=\"text\"]");
    private final By fastAnswer = By.xpath("/html/body/div[6]/div/div/li[1]/span[last()]");
    private final By logo = By.xpath("//div[@class=\"home-logo\"]");

    public mainPage() {
        super();
        open(URL);
    }

    public void typeToInput(String text) {
        find(searchInput).sendKeys(text);
    }

    public boolean isFastAnswer() {
        try {
            WebElement answer = find(fastAnswer);
        } catch (NotFoundException e) {
            System.out.println("Element with fast answer not found!");
            return false;
        }
        return true;
    }

    public String getFastAnswer() {
        return getTextFromElement(fastAnswer);
    }

    public boolean isOpen() {
        try {
            WebElement element = find(logo);
        } catch (NotFoundException e) {
            System.out.println("Page isn't load!");
            return false;
        }
        return isDisplayed(logo);
    }
}
