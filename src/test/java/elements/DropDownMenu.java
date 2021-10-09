package elements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс "Выподающее меню"
public class DropDownMenu extends BaseElement{
    public DropDownMenu(WebDriver driver, By by) {
        super(driver, by);
    }

    // Раскрытие Выподающего миеню
    public void show(){
        WaitFor.visibilityOfElementLocated(by);
        WaitFor.clickabilityOfElement(webElement);
        webElement.click();
    }
}
