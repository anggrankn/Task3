package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Picture picture = new Picture();

        if (testPoint(picture)) {
            readCoordinatesAndPrintColor(picture);
        } else {
            System.out.println("Программа работает не корректно.");
        }
    }

    public static boolean testPoint(Picture picture) {

        Point[] coordinate = {new Point(4, 6),
                new Point(1, 1),
                new Point(-3, -3),
                new Point(3, -6),
                new Point(8, -5),
                new Point(-3, -6),
                new Point(-6, 1),
                new Point(-10, -0.5)};

        SimpleColor[] rightColor = {SimpleColor.BLUE,
                SimpleColor.GRAY,
                SimpleColor.YELLOW,
                SimpleColor.GREEN,
                SimpleColor.ORANGE,
                SimpleColor.WHITE,
                SimpleColor.BLUE,
                SimpleColor.BLUE};

        boolean result = true;

        for (int i = 0; i < rightColor.length; i++) {
            SimpleColor color = picture.getColor(coordinate[i].x, coordinate[i].y);
            SimpleColor correctColor = rightColor[i];

            if (color == correctColor) {
                printTest(coordinate[i], color, correctColor, "Верно.");
            } else {
                printTest(coordinate[i], color, correctColor, "Неверно.");
                result = false;
            }
        }
        return result;
    }

    public static void readCoordinatesAndPrintColor(Picture picture) {
        double x = readCoordinate("x = ");
        double y = readCoordinate("y = ");

        Point point = new Point(x, y);
        SimpleColor color = picture.getColor(point.x, point.y);

        printColorForPoint(color, point);
    }

    public static double readCoordinate(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите значение координаты %s ", name);
        return scanner.nextDouble();
    }

    public static void printColorForPoint(SimpleColor color, Point point) {
        System.out.printf("Координаты точки: (%.1f, %.1f) -> Цвет данной области: %s%n", point.x, point.y, color);
    }

    public static void printTest(Point point, SimpleColor color, SimpleColor correctColor, String result) {
        System.out.println("(" + point.x + ";" + point.y + ") -> " + color +
                ". Корректный цвет: " + correctColor + ". " + result);
    }
}

