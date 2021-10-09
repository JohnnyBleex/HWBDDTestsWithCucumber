package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import webdriverfactory.BrowserName;
import webdriverfactory.PageLoadStrategyName;
import webdriverfactory.WebDriverFactory;

// Базовый класс для всех классов с тестами
public class BaseTest {
    protected static WebDriver driver; // Драйвер браузера

    private Logger logger = LogManager.getLogger(BaseTest.class);

    String browser = System.getProperty("browser", "chrome").toLowerCase(); // Получаем параметр запуска тестов через Maven -Dbrowser
    String option = System.getProperty("option", "normal").toLowerCase();   // Получаем параметр запуска тестов через Maven -Doption

    // Перед каждым тестом
    @BeforeEach
    public void setUp(){
        logger.info("Браузер = " + browser);
        logger.info("Стратегия загрузки страници - " + option);

        // Получаем экземпляр драйвера браузера
        driver = WebDriverFactory.getDriver(BrowserName.fromString(browser), PageLoadStrategyName.fromString(option));
        logger.info("Драйвер запущен!");
    }

    // После каждого теста
    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
