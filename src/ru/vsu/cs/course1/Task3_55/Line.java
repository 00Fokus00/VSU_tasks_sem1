package ru.vsu.cs.course1.Task3_55;

public class Line {
    public double m;
    public double a;
    public Line(double m, double a) {
        this.m = m;
        this.a = a;
    }
    /**
     * Проверяет, находится ли точка (x, y) выше линии
     */
    public boolean isPointAboveLine(double x, double y) {
        return y > a * x + m;
    }
}

