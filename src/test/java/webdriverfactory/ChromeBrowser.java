package webdriverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

// Драйвера браузера "Google Chrome"
public class ChromeBrowser {
    // Получение экземпляра драйвера браузера "Google Chrome"
    public static WebDriver getDriver(PageLoadStrategyName strategyName){
        PageLoadStrategy strategy = LoadingStrategy.loadStrategy(strategyName); // Получение стратегги загрузки через имя

        WebDriverManager.chromedriver().setup(); // Настройка исполняемого файла драйвера

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
        chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
        chromeOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, false);
        chromeOptions.setPageLoadStrategy(strategy);
        chromeOptions.setAcceptInsecureCerts(false);

        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");

        return new ChromeDriver(chromeOptions);
    }
}
