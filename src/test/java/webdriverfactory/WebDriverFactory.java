package webdriverfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

// Фабрика по созданию экземпляров драйвера браузера
public class WebDriverFactory {
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    // Получение экземпляра драйвера по имени
    public static WebDriver getDriver(BrowserName browserName, PageLoadStrategyName strategyName){
        switch (browserName){
            // Драйвер браузера Google Chrome
            case CHROME:
                logger.info("Драйвер браузера Google Chrome");
                return ChromeBrowser.getDriver(strategyName);
            // Драйвер браузера Mozilla Firefox
            case FIREFOX:
                logger.info("Драйвер браузера Firefox");
                return FirefoxBrowser.getDriver(strategyName);
            // По умолчанию
            default:
                throw new RuntimeException("Некорректное наименование браузера!");
        }
    }
}
