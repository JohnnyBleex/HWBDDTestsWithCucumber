package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.elements.Link;
import web.elements.Table;
import web.helpers.WaitHelper;

public class NoteBookProductPage extends BasePage{
    public NoteBookProductPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    // ***** Веб элементы *****
// Ссылка "Характеристики"
    @FindBy(xpath = "//a[text()=\"Характеристики\"]")
    private WebElement linkCharacteristics;
    // Таблица "Характеристики"
    @FindBy(xpath = "//table")
    private WebElement tableCharacteristics;

    // ***** Получение обернутых веб элементов *****
    // Ссылка "Характеристики"
    public Link linkCharacteristics() {
        WaitHelper.visibilityOfElement(linkCharacteristics);
        return new Link(linkCharacteristics);
    }
    // Таблица "Характеристики"
    public Table tableCharacteristics() {
        WaitHelper.visibilityOfElement(tableCharacteristics);
        return new Table(tableCharacteristics);
    }
}
