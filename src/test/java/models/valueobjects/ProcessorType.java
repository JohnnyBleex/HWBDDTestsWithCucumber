package models.valueobjects;

public class ProcessorType {
    //тип процессора
    private String processorType;

    ProcessorType(){

    }

    ProcessorType(String processorType){
        if (!processorType.isBlank() || !processorType.isEmpty())
            this.processorType = processorType;
        else
            throw new IllegalArgumentException("Наименование типа процессора не может быть пустым!");
    }

    // Геттер
    public String getProcessorType() {
        return this.processorType;
    }

    // Переопределенный метод сравнения
    public boolean equals(ProcessorType otherProcessorType) {
        return this.processorType.equals(otherProcessorType.processorType);
    }
}
