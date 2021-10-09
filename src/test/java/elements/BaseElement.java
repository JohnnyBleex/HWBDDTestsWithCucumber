package elements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

//Базовый класс для всех элементов
public class BaseElement {
    protected WebDriver driver; // Драйвер
    protected WebElement webElement; // Элемент
    protected List<WebElement> webElements; // Список элементов
    protected By by; // Локатор

    public BaseElement(WebDriver driver, By by){
        this.driver = driver;
        this.by = by;

        // Ожидание появления элемента перед поиском элемента
        WaitFor.initWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
        WaitFor.presenceOfElementLocated(by);
        WaitFor.visibilityOfElementLocated(by);
        webElement = driver.findElement(by); // Поиск элемента
        webElements = driver.findElements(by); // Поиск элементов
    }

    // Получение оборачиваемого элемента
    // Получив оборачиваемый элемент, можно вызвать его методы
    // Например, getText()
    public WebElement getWebElement(){
        return webElement;
    }
}
