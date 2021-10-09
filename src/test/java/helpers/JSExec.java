package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExec {
    // Исполнитель JS скриптов
    protected static JavascriptExecutor js;

    // Инициализация исполнителя JS скриптов
    public static void initJS(WebDriver driver) {
        js = (JavascriptExecutor) driver;
    }

    // Скролл страницы на заданное расстояние в пикселях по X и по Y
    public static void scrollBy(int x, int y) {
        String script = "window.scrollBy(" + x + "," + y + ");";
        js.executeScript(script);
    }

    // скролл до заданного элемента
    public static void scrollIntoView(WebElement element) {
        String script = "arguments[0].scrollIntoView(true);";
        js.executeScript(script, element);
    }

    public static void scrollIntoView(By by) {
        String script = "arguments[0].scrollIntoView(true);";
        js.executeScript(script, by);
    }

    // Установка невидимости веб элемента
    public static void displayNone(WebElement element) {
        String script = "arguments[0].style.display='none';";
        js.executeScript(script, element);
    }
}
