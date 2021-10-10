package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import models.testobjects.NoteBook;
import models.valueobjects.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import web.drivers.WebDriverFactory;
import web.helpers.JavaScriptHelper;
import web.pages.NoteBookProductPage;
import web.pages.NoteBooksPage;
import web.pages.StartPage;

import java.util.List;
import java.util.Map;

public class NoteBooksSteps {
    private static Logger logger = LogManager.getLogger(NoteBooksSteps.class);
    // Страници
    StartPage startPage;
    NoteBooksPage noteBooksPage;
    NoteBookProductPage noteBookProductPage;

    @Дано("Открыта Главная страница ДНС")
    public void startDriverAndOpenStartPage() {
        startPage = new StartPage(WebDriverFactory.getCurrentDriver());
        noteBooksPage = new NoteBooksPage(WebDriverFactory.getCurrentDriver());
        noteBookProductPage = new NoteBookProductPage(WebDriverFactory.getCurrentDriver());

        WebDriverFactory.getCurrentDriver().get("https://www.dns-shop.ru/");
        logger.info("Открыта Стартовая страница сайта DNS");
    }

    @Когда("Выполнен переход на страницу Ноутбуки")
    public void openNoteBooksPage() {
        startPage.linkYes().click();
        startPage.linkComputers().focusOnLink();
        startPage.linkNoteBooks().click();
        logger.info("Выполнен переход на страницу Ноутбуки");
    }

    @Тогда("Проверить: В заголовке страницы отображется текст Ноутбуки")
    public void assertTitle() {
        // Проверка заголовка страницы
        logger.info("Проверка заголовка страницы");
        Assertions.assertTrue(noteBooksPage.getPageTitle().contains("Ноутбуки"),
                "В заголовке страницы не отображается текст Ноутбуки");
    }

    @Тогда("Проверить: В заголовке страницы отображается текст {string}")
    public void assertTitleNoteBookProduct(String company) {
        // Проверка заголовка страницы
        logger.info("Проверка заголовка страницы");
        Assertions.assertTrue(noteBookProductPage.getPageTitle().contains(company),
                "В заголовке страницы не отображается текст " + company);
    }

    @И("Установлена сортировка {string}")
    public void setSortBy(String sortBy) {
        noteBooksPage.dropDownMenuSort().show();
        noteBooksPage.radioButtonSort(sortBy).setSelected(true);
        logger.info("Услановлена сортировка " + sortBy);
    }

    @И("В фильтре {string} выбрано значение {string}")
    public void setFilterBy(String filterBy, String value) {
        JavaScriptHelper.scrollBy(0, 400);
        switch (filterBy) {
            case "Производитель":
                JavaScriptHelper.scrollBy(0, 400);
                noteBooksPage.textBoxCompany().click().setValue(value);
                noteBooksPage.checkBoxCompany(value).setChecked(true);
                break;
            case "Объем оперативной памяти":
                noteBooksPage.dropDownMenuRAM().show();
                noteBooksPage.checkBoxRAM(value).setChecked(true);
                break;
            case "Линейка процессора":
                noteBooksPage.dropDownMenuProcessorsType().show();
                noteBooksPage.textBoxProcessorType().click().setValue(value);
                noteBooksPage.checkBoxProcessorType(value).setChecked(true);
                break;
            case "Модель дискретной видеокарты":
                noteBooksPage.dropDownMenuModelGPUCard().show();
                noteBooksPage.textBoxModelGPUCard().click().setValue(value);
                noteBooksPage.checkBoxModelGPUCard(value).setChecked(true);
        }
        logger.info("В фильтре " + filterBy + " выбрано значение " + value);
    }

    @И("В фильтре Диагональ экрана выбрано значение от {string} до {string}")
    public void setDiagonalRange(String from, String apTo) {
        noteBooksPage.dropDownMenuDiagonal().show();
        noteBooksPage.textBoxDiagonalFrom().click().setValue(from);
        noteBooksPage.textBoxDiagonalApTo().click().setValue(apTo);
    }

    @И("Применены выбранные фильтры")
    public void applyFilters() {
        JavaScriptHelper.scrollBy(0, 650);
        noteBooksPage.buttonApply().click();
        logger.info("Применены выбранные фильтры");
    }

    @И("Выполнен переход на страницу первого продукта из списка")
    public void selectFirstNoteBook() {
        JavaScriptHelper.scrollBy(0, -1500);
        noteBooksPage.linkFirstProduct().click();
        logger.info("Выполнен переход на страницу первого товара из списка");
    }

    @И("Установлены фильтры из таблицы с одной колонкой")
    public void setFiltersFromTable1(List<String> filters) {
        NoteBook noteBook = new NoteBook(
                new Company(filters.get(0)),
                new Ram(Integer.parseInt(filters.get(1).split(" ")[0])),
                new DiagonalRange(Integer.parseInt(filters.get(2).split(" ")[0])),
                new DiagonalRange(Integer.parseInt(filters.get(3).split(" ")[0])),
                new ProcessorType(filters.get(4)),
                new GpuType(filters.get(5))
        );

        getFilterPage(noteBook);

        logger.info("***** Установлены фильтры из таблицы с одной колонкой");
    }

    @И("Установлены фильтры из таблицы с двумя колонками")
    public void setFiltersFromTable2(Map<String, String> filters) {
        NoteBook noteBook = new NoteBook(
                new Company(filters.get("Производитель")),
                new Ram(Integer.parseInt(filters.get("Объем оперативной памяти").split(" ")[0])),
                new DiagonalRange(Integer.parseInt(filters.get("Диагональ От").split(" ")[0])),
                new DiagonalRange(Integer.parseInt(filters.get("Диагональ До").split(" ")[0])),
                new ProcessorType(filters.get("Линейка процессора")),
                new GpuType(filters.get("Модель дискретной видеокарты"))
        );

        getFilterPage(noteBook);

        logger.info("***** Установлены фильтры из таблицы с двумя колонками");
    }

    @И("Установлены фильтры из таблицы с семью колонками")
    public void setFiltersFromTable3(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        String sortBy = table.get(0).get("Сортировка");
        String filterByCompany = table.get(0).get("Производитель");
        String filterByRam = table.get(0).get("Объем оперативной памяти");
        String filterByDiagonalFrom = table.get(0).get("Диагональ От");
        String filterByDiagonalApTo = table.get(0).get("Диагональ До");
        String filterByProcessorType = table.get(0).get("Линейка процессора");
        String filterByModelGpu = table.get(0).get("Модель дискретной видеокарты");

        NoteBook noteBook = new NoteBook(
                new Company(filterByCompany),
                new Ram(Integer.parseInt(filterByRam.split(" ")[0])),
                new DiagonalRange(Integer.parseInt(filterByDiagonalFrom.split(" ")[0])),
                new DiagonalRange(Integer.parseInt(filterByDiagonalApTo.split(" ")[0])),
                new ProcessorType(filterByProcessorType),
                new GpuType(filterByModelGpu)
        );

        noteBooksPage.dropDownMenuSort().show();
        noteBooksPage.radioButtonSort(sortBy).setSelected(true);
        getFilterPage(noteBook);

        logger.info("***** Установлены фильтры из таблицы с семью колонкоами");
    }

    public void getFilterPage(NoteBook noteBook){
        JavaScriptHelper.scrollBy(0, 800);
        noteBooksPage.textBoxCompany().click().setValue(noteBook.getCompany().getCompany());
        noteBooksPage.checkBoxCompany(noteBook.getCompany().getCompany()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);
        noteBooksPage.dropDownMenuRAM().show();
        noteBooksPage.checkBoxRAM(noteBook.getRam().getRam() + " ГБ").setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);
        noteBooksPage.dropDownMenuDiagonal().show();
        noteBooksPage.textBoxDiagonalFrom().click().setValue(noteBook.getDiagonalRangeFrom().getDiagonalRange() + "");
        noteBooksPage.textBoxDiagonalApTo().click().setValue(noteBook.getDiagonalRangeApTo().getDiagonalRange() + "");
        JavaScriptHelper.scrollBy(0, 200);
        noteBooksPage.dropDownMenuProcessorsType().show();
        noteBooksPage.textBoxProcessorType().click().setValue(noteBook.getProcessorType().getProcessorType());
        noteBooksPage.checkBoxProcessorType(noteBook.getProcessorType().getProcessorType()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 200);
        noteBooksPage.dropDownMenuModelGPUCard().show();
        noteBooksPage.textBoxModelGPUCard().click().setValue(noteBook.getGpuType().getGpuType());
        noteBooksPage.checkBoxModelGPUCard(noteBook.getGpuType().getGpuType()).setChecked(true);
    }
}
