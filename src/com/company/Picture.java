package com.company;

public class Picture {
    public final Circle circle;
    public final Line line;
    public final VerticalParabola verticalParabola1;
    public final VerticalParabola verticalParabola2;

    public Picture() {
        this.circle = new Circle(-5, 6, 3);
        this.line = new Line(0, -4, 1);
        this.verticalParabola1 = new VerticalParabola(-6, 3, -0.5);
        this.verticalParabola2 = new VerticalParabola(0, 2, -0.25);
    }

    public SimpleColor getColor(double x, double y) {
        if (!circle.isPointAbove(x, y)) {
            return SimpleColor.ORANGE;
        }
        if (!verticalParabola2.isPointAbove(x, y) && line.isPointAbove(0, y) && verticalParabola1.isPointAbove(x, y)) {
            return SimpleColor.GRAY;
        }
        if (!verticalParabola2.isPointAbove(x, y) && line.isPointAbove(0, y) && !verticalParabola1.isPointAbove(x, y)) {
            return SimpleColor.YELLOW;
        }
        if (!verticalParabola2.isPointAbove(x, y) && !line.isPointAbove(0, y) && verticalParabola1.isPointAbove(x, y)) {
            return SimpleColor.GREEN;
        }
        if (verticalParabola2.isPointAbove(x, y) && !line.isPointAbove(0, y) && (x > 0)) {
            return SimpleColor.ORANGE;
        }
        if (!line.isPointAbove(0, y) && !verticalParabola1.isPointAbove(x, y)) {
            return SimpleColor.WHITE;
        }
        if (verticalParabola2.isPointAbove(x, y) && circle.isPointAbove(x, y) && line.isPointAbove(0, y)) {
            return SimpleColor.BLUE;
        } else {
            return SimpleColor.BLUE;
        }
    }
}
