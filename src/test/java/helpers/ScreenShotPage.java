package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Sleeper;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import tests.BaseTest;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

// Класс
public class ScreenShotPage extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ScreenShotPage.class);

    // Сделать скриншот страници
    public static void getScreenShot(String path) {
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(2));
            Screenshot screenshot = new AShot().takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "png", new File(path));
            logger.info("Скриншот сохранен в " + path);
        } catch (IOException exception) {
            exception.printStackTrace();
            logger.info("Не верно указан путь!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
