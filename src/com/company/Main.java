            package com.company;

            import java.util.Scanner;

            public class Main {

                public static void main(String[] args) {

                    Picture picture = new Picture(new Circle(-5, 6, 3), new Line(0, -4, 1),
                            new VerticalParabola(-6, 3, -0.5), new VerticalParabola(0, 2, -0.25));

                    if (testPoint(picture)) {
                        readCoordinatesAndPrintColor(picture);
                    } else {
                        System.out.println("The program does not work correctly");
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
                            printTest(coordinate[i], color, correctColor, "TRUE");
                        } else {
                            printTest(coordinate[i], color, correctColor, "FALSE");
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
                    System.out.printf("Input the coordinate value %s ", name);
                    return scanner.nextDouble();
                }

                public static void printColorForPoint(SimpleColor color, Point point) {
                    System.out.printf("Color: (%.1f, %.1f) -> Point: %s%n", point.x, point.y, color);
                }

                public static void printTest(Point point, SimpleColor color, SimpleColor correctColor, String result) {
                    System.out.println("(" + point.x + ";" + point.y + ") --> " + color +
                            ". Right color --> " + correctColor + ". " + result);
                }
            }
