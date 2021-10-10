package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import web.drivers.BrowserName;
import web.drivers.PageLoadStrategyName;
import web.drivers.WebDriverFactory;

public class DriverHooks {
    private Logger logger = LogManager.getLogger(DriverHooks.class);

    protected static WebDriver driver;

    @Before
    public void startDriverBeforeScenario() {
        String browser = System.getProperty("browser", "chrome").toLowerCase(); // Получаем параметр запуска тестов через Maven -Dbrowser
        String option = System.getProperty("option", "normal").toLowerCase();   // Получаем параметр запуска тестов через Maven -Doption
        driver = WebDriverFactory.getDriver(BrowserName.fromString(browser), PageLoadStrategyName.fromString(option));
        logger.info("Драйвер стартовал!");
    }

    // Действия совершаемые после каждого сценария
    @After
    public void stopDriverAfterScenario() {
        // Если драйвер еще существует
        if(driver != null) {
            // Закрываем его
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
