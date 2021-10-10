package web.pages;

import org.openqa.selenium.WebDriver;
import web.helpers.ActionHelper;
import web.helpers.JavaScriptHelper;
import web.helpers.WaitHelper;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;

    // Конструктор базового класса
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        // Инициализация ожидания - 10 секунд
        WaitHelper.init(Duration.ofSeconds(10), Duration.ofMillis(100));
        // Инициализация исполнителя JS скриптов
        JavaScriptHelper.init();
        // Инициализация экшена
        ActionHelper.init();
    }

    // Получение заголовка текущей страницы
    public String getPageTitle() {
        return driver.getTitle();
    }
}
