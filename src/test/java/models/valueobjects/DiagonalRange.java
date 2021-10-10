package models.valueobjects;

import java.io.Serializable;

public class DiagonalRange implements Serializable {
    private int diagonalRange; // Диарозон диагонали

    public DiagonalRange() {

    }

    public DiagonalRange(int diagonalRange) {
        if (diagonalRange > 0) {
            this.diagonalRange = diagonalRange;
        }else {
            throw new IllegalArgumentException("Диоганаль не может быть меньше нуля!");
        }
    }

    // Геттер
    public int getDiagonalRange(){
        return this.diagonalRange;
    }

    // Переопределенный метод сравнения
    public boolean equals(DiagonalRange otherDiagonalRange){
        return this.diagonalRange == otherDiagonalRange.diagonalRange;
    }
}
