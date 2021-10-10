package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.WaitHelper;

public class DropDownMenu extends BaseElement{
    public DropDownMenu(WebElement webElement) {
        super(webElement);
    }

    // Раскрытие меню
    public void show() {
        // Ожидание кликабельности меню
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }
}
