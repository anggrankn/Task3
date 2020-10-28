package com.company;

public class Picture {
    public final Circle Circle;
    public final Line Line;
    public final VerticalParabola VerticalParabola1;
    public final VerticalParabola VerticalParabola2;

    public Picture(Circle Circle, Line Line, VerticalParabola VerticalParabola1, VerticalParabola VerticalParabola2) {
        this.Circle = Circle;
        this.Line = Line;
        this.VerticalParabola1 = VerticalParabola1;
        this.VerticalParabola2 = VerticalParabola2;
    }

    public SimpleColor getColor(double x, double y) {
        if (!Circle.isPointAbove(x, y)) {
            return SimpleColor.ORANGE;//area1
        }
        if (!VerticalParabola2.isPointAbove(x, y) && Line.isPointAbove(0, y) && VerticalParabola1.isPointAbove(x, y)) {
            return SimpleColor.GRAY; //area2
        }
        if (!VerticalParabola2.isPointAbove(x, y) && Line.isPointAbove(0, y) && !VerticalParabola1.isPointAbove(x, y)) {
            return SimpleColor.YELLOW; //area3
        }
        if (!VerticalParabola2.isPointAbove(x, y) && !Line.isPointAbove(0, y) && VerticalParabola1.isPointAbove(x, y)) {
            return SimpleColor.GREEN; //area4
        }
        if (VerticalParabola2.isPointAbove(x, y) && !Line.isPointAbove(0, y) && (x > 0)) {
            return SimpleColor.ORANGE; //area5
        }
        if (!Line.isPointAbove(0, y) && !VerticalParabola1.isPointAbove(x, y)) {
            return SimpleColor.WHITE; //area6
        }
        if (VerticalParabola2.isPointAbove(x, y) && Circle.isPointAbove(x, y) && Line.isPointAbove(0, y)) {
            return SimpleColor.BLUE; //area7
        } else {
            return SimpleColor.BLUE; //area8
        }
    }
}
