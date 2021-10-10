package web.helpers;

import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Sleeper;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import web.drivers.WebDriverFactory;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;

// Класс
public class ScreenShotPage {
    private static final Logger logger = LogManager.getLogger(ScreenShotPage.class);

    // Сделать скриншот страници
    public static void getScreenShot(Scenario scenario) {
        try {
            Screenshot screenshot = new AShot().takeScreenshot(WebDriverFactory.getCurrentDriver());
            String name = scenario.getName() + "-" + Timestamp.from(Instant.now()).getTime() + ".png";
            ImageIO.write(screenshot.getImage(), "png", new File("target//" + name));
            logger.info("Скриншот сохранен в [target//" + name + "]");
        } catch (IOException exception) {
            exception.printStackTrace();
            logger.info("Не верно указан путь!");
        }
    }
}
