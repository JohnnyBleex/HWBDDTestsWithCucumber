package webdriverfactory;

// Имена стратегии загрузки страници
public enum PageLoadStrategyName {
    // Имена стратегии загрузки страници
    NORMAL("normal"), // Стратегия загрузки NORMAL
    EAGER("eager"),   // Стратегия загрузки EAGER
    NONE("none");     // Стратегия загрузки NONE

    private String strategyName; // Имя стратегии загрузки

    private PageLoadStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return String.valueOf(this.strategyName);
    }

    // Возврат константы по строковому значению константы
    public static PageLoadStrategyName fromString(String strategyName) {
        if (strategyName != null) {
            for (PageLoadStrategyName name : PageLoadStrategyName.values()) {
                if (strategyName.equalsIgnoreCase(name.strategyName)) {
                    return name;
                }
            }
        }
        return null;
    }

    // Получение имени стратегии загрузки
    public String getStrategyName() {
        return this.strategyName;
    }
}
