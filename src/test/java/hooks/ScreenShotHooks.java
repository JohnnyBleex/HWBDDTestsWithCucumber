package hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import web.helpers.ScreenShotPage;

public class ScreenShotHooks {
    // Действия совершаемые перед каждым шагом
    @BeforeStep
    public void takeScreenShotBeforeStep(Scenario scenario){
        ScreenShotPage.getScreenShot(scenario);
    }

    // Действия совершаемые после каждого шага
    @AfterStep
    public void takeScreenShotAfterStep(Scenario scenario){
        ScreenShotPage.getScreenShot(scenario);
    }
}
