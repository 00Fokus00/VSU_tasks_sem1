package ru.vsu.cs.course1.task3;

public class Picture {
    public static final Line L1 = new Line(1,0.25);
    public static final Line L2 = new Line(3, -2);
    public static  final VerticalParabola V1 = new VerticalParabola(4, 0, -0.5);
    public static final HorizontalParabola H1 = new HorizontalParabola(0, -4, -0.125);
    public static final HorizontalParabola H2 = new HorizontalParabola(-3, 2, -1);

    public static Enum.SimpleColor getColor(double x, double y){
        if (H1.isPointRightOfParabola(x, y) && L1.isPointAboveLine(x, y)){
            return Enum.SimpleColor.WHITE;
        }
        if (!H1.isPointRightOfParabola(x, y) && !L1.isPointAboveLine(x, y)) {
            return Enum.SimpleColor.BLUE;
        }
        if (!H1.isPointRightOfParabola(x, y) && L1.isPointAboveLine(x, y)) {
            return Enum.SimpleColor.GREEN;
        }
        if (!L2.isPointAboveLine(x, y) && !V1.isPointAboveOfParabola(x, y)){
            return Enum.SimpleColor.GRAY;
        }
        if (L2.isPointAboveLine(x, y) && !V1.isPointAboveOfParabola(x, y)) {
            return Enum.SimpleColor.GREEN;
        }
        if (L2.isPointAboveLine(x, y) && V1.isPointAboveOfParabola(x, y) && !L1.isPointAboveLine(x, y) ) {
            return Enum.SimpleColor.ORANGE;
        }
        return Enum.SimpleColor.YELLOW;
    }

    public static void printColorForPoint(double x, double y) {
        System.out.printf("(%.3f, %.3f) -> %s%n", x, y, getColor(x, y));
    }

}
