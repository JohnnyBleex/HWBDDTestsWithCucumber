package elements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

// Класс "Ссылка"
public class Link extends BaseElement{
    public Link(WebDriver driver, By by) {
        super(driver, by);
    }

    // Нажатие на ссылку
    public void click() {
        WaitFor.visibilityOfElementLocated(by);
        WaitFor.clickabilityOfElement(webElement);
        webElement.click();
    }

    // Наведение курсора мыши на ссылку
    public void focusOnLink(){
        WaitFor.visibilityOfElementLocated(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }

    // Открытие ссылки в новом окне
    public void openInNuwWindow(){
        String url = this.getUrl(0);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    // Получение URL ссылки
    public String getUrl(){
        return webElement.getAttribute("href");
    }

    // Получение URL ссылки из элемента со списка
    public String getUrl(int id){
        return webElements.get(id).getAttribute("href");
    }

    // Получение текста ссылки
    public String getText(){
        WaitFor.visibilityOfElementLocated(by);
        return webElement.getText();
    }
}
