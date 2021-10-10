package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.elements.Link;

public class StartPage extends BasePage{
    public StartPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    // ***** Веб элементы *****
    // Кнопка "Да" на всплывашке
    @FindBy(xpath = "//a[contains(text(),'Да')]")
    private WebElement linkYes;
    // Ссылка "Компьютеры"
    @FindBy(xpath = "(//a[contains(text(), 'Компьютеры')])[1]")
    private WebElement linkComputers;
    // Ссылка "Ноутбуки"
    @FindBy(xpath = "//a[text()='Ноутбуки']")
    private WebElement linkNoteBooks;

    public Link linkYes(){
        return new Link(linkYes);
    }

    public Link linkComputers(){
        return new Link(linkComputers);
    }

    public Link linkNoteBooks(){
        return new Link(linkNoteBooks);
    }
}
