package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Главный класс для демонстрации работы всех сущностей. */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    /** Точка входа в программу. */
    public static void main(String[] args) {
        demonstratePoint();   // Задание 1.1: Точка на плоскости
        demonstrateName();    // Задание 1.2: Имена
        demonstrateLine();    // Задание 2.1: Прямая (Линия)
        demonstrateCity();    // Задание 3.3 и 5: Города
        demonstrateFraction(); // Задание 5.5: Дроби

        scanner.close();
    }

    /** Демонстрация работы класса Point. */
    private static void demonstratePoint() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Задание 1.1 - Точка на плоскости");
        System.out.println("=".repeat(50));

        // Создание трёх точек с разными координатами
        Point point1 = new Point(2.5, 3.7);
        Point point2 = new Point(-1.0, 4.2);
        Point point3 = new Point(0, -5.8);

        // Вывод текстового представления точек
        System.out.println("Точка 1: " + point1);
        System.out.println("Точка 2: " + point2);
        System.out.println("Точка 3: " + point3);
    }

    /** Ввод точки с клавиатуры с проверкой на корректность ввода. */
    private static Point inputPoint() {
        double x = 0, y = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print("Введите координату X: ");
                x = Double.parseDouble(scanner.nextLine());
                System.out.print("Введите координату Y: ");
                y = Double.parseDouble(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное число!");
            }
        }
        return new Point(x, y);
    }

    /** Демонстрация работы класса Name. */
    private static void demonstrateName() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Задание 1.2 - Имена");
        System.out.println("=".repeat(50));

        // FIX_ME: в исходном коде имя "Клеопатра" создавалось неправильно
        // Старый код:
        // Name name1 = new Name("", "Клеопатра", "");
        // Новый код:
        Name name1 = new Name("Клеопатра");                    // Только имя
        Name name2 = new Name("Пушкин", "Александр", "Сергеевич"); // Фамилия, имя, отчество
        Name name3 = new Name("Маяковский", "Владимир");       // Фамилия и имя

        System.out.println("Имя 1: " + name1);
        System.out.println("Имя 2: " + name2);
        System.out.println("Имя 3: " + name3);
    }

    /** Демонстрация работы класса Line. */
    private static void demonstrateLine() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Задание 2.1 - Прямая (Линия)");
        System.out.println("=".repeat(50));

        // 1. Линия 1: начало {1;3}, конец {23;8}
        Point line1Start = new Point(1, 3);
        Point line1End = new Point(23, 8);
        Line line1 = new Line(line1Start, line1End);
        System.out.println("Линия 1: " + line1);

        // 2. Линия 2: горизонтальная, y=10, x от 5 до 25
        Point line2Start = new Point(5, 10);
        Point line2End = new Point(25, 10);
        Line line2 = new Line(line2Start, line2End);
        System.out.println("Линия 2: " + line2);

        // 3. Линия 3: начало как у линии 1, конец как у линии 2
        Line line3 = new Line(line1.getStart(), line2.getEnd());
        System.out.println("Линия 3: " + line3);

        // 4. Изменение координат первой и второй линий
        System.out.println("\n--- Изменение координат линий 1 и 2 ---");
        line1.getStart().setX(0);
        line1.getStart().setY(0);
        line1.getEnd().setX(20);
        line1.getEnd().setY(5);

        line2.getStart().setX(0);
        line2.getStart().setY(15);
        line2.getEnd().setX(30);
        line2.getEnd().setY(15);

        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3: " + line3);

        // 5. Изменение линии 1 без влияния на линию 3
        System.out.println("\n--- Изменение линии 1 без влияния на линию 3 ---");
        Point newLine1Start = new Point(10, 10);
        Point newLine1End = new Point(30, 30);
        line1.setStart(newLine1Start);
        line1.setEnd(newLine1End);

        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 3: " + line3);
    }

    /** Демонстрация работы класса City. */
    private static void demonstrateCity() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Задание 3.3 и 5 - Города");
        System.out.println("=".repeat(50));

        // Создание городов
        City cityA = new City("A");
        City cityB = new City("B");
        City cityC = new City("C");
        City cityD = new City("D");
        City cityE = new City("E");
        City cityF = new City("F");

        // A → B(5), F(1), D(6)
        cityA.addPath(cityB, 5);
        cityA.addPath(cityF, 1);
        cityA.addPath(cityD, 6);

        // B → A(5), C(3)
        cityB.addPath(cityA, 5);
        cityB.addPath(cityC, 3);

        // F → B(1), E(2)
        cityF.addPath(cityB, 1);
        cityF.addPath(cityE, 2);

        // C → B(3), D(4)
        cityC.addPath(cityB, 3);
        cityC.addPath(cityD, 4);

        // D → C(4), E(2), A(6)
        cityD.addPath(cityC, 4);
        cityD.addPath(cityE, 2);
        cityD.addPath(cityA, 6);

        // E → F(2), D(2)
        cityE.addPath(cityF, 2);
        cityE.addPath(cityD, 2);

        // Вывод схемы городов
        System.out.println("Схема городов:");
        System.out.println(cityA);
        System.out.println(cityB);
        System.out.println(cityC);
        System.out.println(cityD);
        System.out.println(cityE);
        System.out.println(cityF);

        // Демонстрация новых конструкторов
        System.out.println("\n--- Новые конструкторы ---");
        City simpleCity = new City("ПростойГород");
        System.out.println("Город только с названием: " + simpleCity);

        List<City> connectedCities = new ArrayList<>();
        List<Integer> costs = new ArrayList<>();
        connectedCities.add(cityB);
        costs.add(10);
        connectedCities.add(cityC);
        costs.add(15);

        City advancedCity = new City("ПродвинутыйГород", connectedCities, costs);
        System.out.println("Город с готовыми связями: " + advancedCity);
    }

    /** Демонстрация работы класса Fraction. */
    private static void demonstrateFraction() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Задание 5.5 - Дроби");
        System.out.println("=".repeat(50));

        // Создание дробей
        Fraction f1 = new Fraction(1, 3); // 1/3
        Fraction f2 = new Fraction(2, 3); // 2/3
        Fraction f3 = new Fraction(3, 4); // 3/4
        Fraction f4 = new Fraction(5, 6); // 5/6

        System.out.println("Созданные дроби:");
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("f3 = " + f3);
        System.out.println("f4 = " + f4);

        // Примеры операций
        System.out.println("\nПримеры операций:");

        // Сложение дробей
        Fraction sumResult = f1.add(f2);
        System.out.println(Fraction.operationToString(f1, "+", f2, sumResult));

        // Вычитание дробей
        Fraction minusResult = f3.minus(f4);
        System.out.println(Fraction.operationToString(f3, "-", f4, minusResult));

        // Умножение дробей
        Fraction multiplyResult = f1.multiply(f2);
        System.out.println(Fraction.operationToString(f1, "*", f2, multiplyResult));

        // Деление дробей
        Fraction divResult = f3.div(f4);
        System.out.println(Fraction.operationToString(f3, "/", f4, divResult));

        // Операции с целыми числами
        System.out.println(Fraction.operationToString(f1, "+", 2, f1.add(2)));
        System.out.println(Fraction.operationToString(f2, "-", 1, f2.minus(1)));
        System.out.println(Fraction.operationToString(f3, "*", 3, f3.multiply(3)));
        System.out.println(Fraction.operationToString(f4, "/", 2, f4.div(2)));

        // Вычисление f1.add(f2).div(f3).minus(5)
        System.out.println("\nВычисление f1.add(f2).div(f3).minus(5):");
        Fraction complexResult = f1.add(f2).div(f3).minus(5);
        System.out.println("f1.add(f2).div(f3).minus(5) = " + complexResult);
    }
}