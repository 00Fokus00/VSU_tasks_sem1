package ru.vsu.cs.course1.task3;

public class VerticalParabola {
    public double x0;
    public double y0;
    public double a;

    public VerticalParabola(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }
    /**
     * Проверяет, находится ли точка (x, y) сверху от параболы
     */
    public boolean isPointAboveOfParabola(double x, double y) {
        return y > a * Math.pow(x - x0, 2) + y0;
    }
}
