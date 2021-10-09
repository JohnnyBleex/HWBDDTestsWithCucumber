package webdriverfactory;

import org.openqa.selenium.PageLoadStrategy;

// Класс для создания стратегии загрузки браузера
public class LoadingStrategy {
    public static PageLoadStrategy loadStrategy(PageLoadStrategyName strategyName) {
        switch (strategyName) {
            // Стратегия загрузки NONE
            case NONE:
                return PageLoadStrategy.NONE;
            // Стратегия загрузки EAGER
            case EAGER:
                return PageLoadStrategy.EAGER;
            // Стратегия загрузки NORMAL
            case NORMAL:
                return PageLoadStrategy.NORMAL;
            // По умолчанию
            default:
                throw new RuntimeException("Некорректное наименование загрузки стратегии браузера!");
        }
    }
}
