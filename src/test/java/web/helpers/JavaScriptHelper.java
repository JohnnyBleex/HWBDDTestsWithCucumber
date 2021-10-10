package web.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import web.drivers.WebDriverFactory;

public class JavaScriptHelper {
    protected static JavascriptExecutor javascriptExecutor;

    public static void init(){
        javascriptExecutor = (JavascriptExecutor) WebDriverFactory.getCurrentDriver();
    }

    // Скролл страницы на заданное расстояние в пикселях по X и по Y
    public static void scrollBy(int x, int y) {
        String script = "window.scrollBy(" + x + "," + y + ");";
        javascriptExecutor.executeScript(script);
    }

    // Установка невидимости веб элемента
    public static void displayNone(WebElement element) {
        String script = "arguments[0].style.display='none';";
        javascriptExecutor.executeScript(script, element);
    }
}
