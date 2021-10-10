package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;
import web.elements.*;
import web.helpers.WaitHelper;

import java.time.Duration;

public class NoteBooksPage extends BasePage{
    public NoteBooksPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    // ***** Веб элементы *****
    // Шапка
    @FindBy(xpath = "//header")
    private WebElement mainBlock;

    @FindBy(xpath = "//span[text()= 'Производитель']/parent::a/following-sibling::div//input[@class='ui-input-search__input ui-input-search__input_list']")
    private WebElement textBoxCompany;
    @FindBy(xpath = "//span[text()='Производитель']/parent::a/following-sibling::div//div[@class='ui-checkbox-group ui-checkbox-group_list']")
    private WebElement divCompany;

    @FindBy(xpath = "//div[@class='ui-list-controls ui-collapse ui-collapse_list']//span[contains(text(), 'Объем оперативной памяти')]")
    private WebElement dropDownMenuRAM;
    @FindBy(xpath = "//span[text()='Объем оперативной памяти (ГБ)']/parent::a/following-sibling::div//div[@class='ui-list-controls__content']")
    private WebElement divRAM;

    @FindBy(xpath = "//span[text()='Диагональ экрана (дюйм)']")
    private WebElement dropDownMenuDiagonal;
    @FindBy(xpath = "//input[@placeholder='от 11.6']")
    private WebElement textBoxDiagonalRangeFrom;
    @FindBy(xpath = "//input[@placeholder='до 17.3']")
    private WebElement textBoxDiagonalRangeApTo;

    @FindBy(xpath = "//a/span[text()='Линейка процессора']")
    private WebElement dropDownMenuProcessorsType;
    @FindBy(xpath = "//span[text()= 'Линейка процессора']/parent::a/following-sibling::div//input[@class='ui-input-search__input ui-input-search__input_list']")
    private WebElement textBoxProcessorType;
    @FindBy(xpath = "//a/span[text()='Линейка процессора']/parent::a/following-sibling::div//div[@class='ui-checkbox-group ui-checkbox-group_list']")
    private WebElement divProcessorType;

    @FindBy(xpath = "//a/span[text()='Модель дискретной видеокарты']")
    private WebElement dropDownMenuModelGPUCard;
    @FindBy(xpath = "//span[text()= 'Модель дискретной видеокарты']/parent::a/following-sibling::div//input[@class='ui-input-search__input ui-input-search__input_list']")
    private WebElement textBoxModelGPUCard;
    @FindBy(xpath = "//a/span[text()='Модель дискретной видеокарты']/parent::a/following-sibling::div//div[@class='ui-checkbox-group ui-checkbox-group_list']")
    private WebElement divModelGPUCard;
    // Кнопка "Применить"
    @FindBy(xpath = "//button[contains(text(), 'Применить')]")
    private WebElement buttonApply;
    // Сортировка
    // Выподающее меню "Сортировка"
    @FindBy(xpath = "//span[contains(text(), \"Сортировка:\")]/following::a")
    private WebElement dropDownMenuSort;
    // Блок с переключателями "Сортировка"
    @FindBy(xpath = "(//div[@class=\"top-filter__radio-list ui-radio top-filter__popover\"])[1]")
    private WebElement divSort;
    // Ноутбуки
    // Ссылка на первый продукт в списке
    @FindBy(xpath = "(//a[contains(@class, 'catalog-product__name')])[1]")
    private WebElement linkFirstProduct;

    // ***** Получение обернутых веб элементов *****
    // Шапка
    public MainBlock mainBlock() {
        return new MainBlock(mainBlock);
    }

    // Фильтры
    // Фильтр "Производитель"
    // Чекбокс "Производитель"
    public TextBox textBoxCompany(){
        return new TextBox(textBoxCompany);
    }
    public CheckBox checkBoxCompany(String company) {
        return new CheckBox(findCheckBoxCompany(company));
    }
    // Поиск чекбокса "Производитель"
    private WebElement findCheckBoxCompany(String company) {
        WaitHelper.visibilityOfElement(divCompany);
        return divCompany.findElement(By.xpath("//label/span[contains(text(), \"" + company + "\")]"));
    }

    // Фильтр "Объем оперативной памяти"
    // Выподающее меню "Объем оперативной памяти"
    public DropDownMenu dropDownMenuRAM() {
        return new DropDownMenu(dropDownMenuRAM);
    }
    // Чекбокс "Объем оперативной памяти"
    public CheckBox checkBoxRAM(String ram) {
        return new CheckBox(findCheckBoxRAM(ram));
    }
    // Поиск чекбокса "Объем оперативной памяти"
    private WebElement findCheckBoxRAM(String ram) {
        WaitHelper.visibilityOfElement(divRAM);
        return divRAM.findElement(By.xpath("//label/span[contains(text(), \"" + ram + "\")]"));
    }

    // Фильтор диагональ
    // Выподающее меня диагональ
    public DropDownMenu dropDownMenuDiagonal(){
        return new DropDownMenu(dropDownMenuDiagonal);
    }
    // Текстбок диагональ от
    public TextBox textBoxDiagonalFrom(){
        return new TextBox(textBoxDiagonalRangeFrom);
    }
    // Текстбок диагональ до
    public TextBox textBoxDiagonalApTo(){
        return new TextBox(textBoxDiagonalRangeApTo);
    }

    // Фильтр процессор
    // Выподающее меню процессор
    public DropDownMenu dropDownMenuProcessorsType(){
        return new DropDownMenu(dropDownMenuProcessorsType);
    }
    // Текстбокс тип процессора
    public TextBox textBoxProcessorType(){
        return new TextBox(textBoxProcessorType);
    }
    // Чекбокс тип роцессора
    public CheckBox checkBoxProcessorType(String processorName){
        return new CheckBox(findProcessorType(processorName));
    }
    // Поиск чекбокса процессор
    private WebElement findProcessorType(String processorName){
        WaitHelper.visibilityOfElement(divProcessorType);
        return divProcessorType.findElement(By.xpath("//label/span[contains(text(), \"" + processorName + "\")]"));
    }

    // Фильтр тип дискретной видеокарты
    // Выподающее меня дискретной видеокарты
    public DropDownMenu dropDownMenuModelGPUCard(){
        return new DropDownMenu(dropDownMenuModelGPUCard);
    }
    public TextBox textBoxModelGPUCard(){
        return new TextBox(textBoxModelGPUCard);
    }
    // Чекбокс модель видеокарты
    public CheckBox checkBoxModelGPUCard(String gpuName){
        return new CheckBox(findModelGPUCard(gpuName));
    }
    // Поиск чекбокса видеокарты
    private WebElement findModelGPUCard(String gpuName){
        WaitHelper.visibilityOfElement(divModelGPUCard);
        return divModelGPUCard.findElement(By.xpath("//label/span[contains(text(), \"" + gpuName + "\")]"));
    }

    // кнопка применить
    public Button buttonApply(){
        return new Button(buttonApply);
    }

    // Сортировка
    // Аккордеон "Сортировка"
    public DropDownMenu dropDownMenuSort() {
        return new DropDownMenu(dropDownMenuSort);
    }
    // Переключатель "Сортировка"
    public RadioButton radioButtonSort(String sort) {
        return new RadioButton(findRadioButtonSort(sort));
    }
    // Поиск переключателя "Сортировка"
    private WebElement findRadioButtonSort(String sort) {
        WaitHelper.visibilityOfElement(divSort);
        return divSort.findElement(By.xpath("//span[contains(text(), \"" + sort + "\")]"));
    }

    // Ссылка на первый продукт в списке
    public Link linkFirstProduct() {
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofMillis(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Link(linkFirstProduct);
    }
}
