package web.drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

// Фабрика по созданию экземпляров драйвера браузера
public class WebDriverFactory {
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    private static WebDriver driver;

    // Получение экземпляра драйвера по имени
    public static WebDriver getDriver(BrowserName browserName, PageLoadStrategyName strategyName) {
        switch (browserName) {
            // Драйвер браузера Google Chrome
            case CHROME:
                logger.info("Драйвер браузера Google Chrome");
                driver = ChromeBrowser.getDriver(strategyName);
                return driver;
                // Драйвер браузера Mozilla Firefox
            case FIREFOX:
                logger.info("Драйвер браузера Firefox");
                driver = FirefoxBrowser.getDriver(strategyName);
                return driver;
            // По умолчанию
            default:
                throw new RuntimeException("Некорректное наименование браузера!");
        }
    }

    // Получение уже созданного экземпляра драйвера
    public static WebDriver getCurrentDriver() {
        return driver;
    }
}
