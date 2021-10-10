package models.valueobjects;

import java.io.Serializable;

public class GpuType implements Serializable {
    // Тип диспретной видео карты
    private String gpuType;

    GpuType(){

    }

    GpuType(String gpuType){
        if (!gpuType.isBlank() || !gpuType.isEmpty())
            this.gpuType = gpuType;
        else
            throw new IllegalArgumentException("Наименование типа процессора не может быть пустым!");
    }

    // Геттер
    public String getGpuType() {
        return this.gpuType;
    }

    // Переопределенный метод сравнения
    public boolean equals(GpuType otherGpuType) {
        return this.gpuType.equals(otherGpuType.gpuType);
    }
}
