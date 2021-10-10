package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.WaitHelper;

public class TextBox extends BaseElement{
    public TextBox(WebElement webElement) {
        super(webElement);
    }

    // Нажатие на текстовое поле ввода
    public TextBox click() {
        // Ожидание кликабельности флажка текстового поля ввода
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
        return this;
    }

    // Ввод значения в текстовое поле ввода
    public TextBox setValue(String value) {
        // Ожидание кликабельности флажка текстового поля ввода
        WaitHelper.clickabilityOfElement(webElement);
        webElement.sendKeys(value);
        return this;
    }
}
