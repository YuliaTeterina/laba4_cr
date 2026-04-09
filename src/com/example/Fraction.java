package com.example;

/** Сущность Дробь с операциями сложения, вычитания, умножения и деления. */
public class Fraction {
    private int numerator;   // Числитель
    private int denominator; // Знаменатель

    /** Конструктор с числителем и знаменателем. */
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    /** Конструктор только с числителем (знаменатель = 1). */
    public Fraction(int numerator) {
        this(numerator, 1);
    }

    /** Конструктор по умолчанию (дробь 0/1). */
    public Fraction() {
        this(0, 1);
    }

    /** Возвращает числитель. */
    public int getNumerator() {
        return numerator;
    }

    /** Возвращает знаменатель. */
    public int getDenominator() {
        return denominator;
    }

    /** Находит наибольший общий делитель (алгоритм Евклида). */
    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /** Упрощает дробь (сокращает и приводит знаменатель к положительному). */
    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    /** Сложение с другой дробью (возвращает новую дробь). */
    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /** Сложение с целым числом (возвращает новую дробь). */
    public Fraction add(int number) {
        return add(new Fraction(number));
    }

    /** Вычитание другой дроби (возвращает новую дробь). */
    public Fraction minus(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /** Вычитание целого числа (возвращает новую дробь). */
    public Fraction minus(int number) {
        return minus(new Fraction(number));
    }

    /** Умножение на другую дробь (возвращает новую дробь). */
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /** Умножение на целое число (возвращает новую дробь). */
    public Fraction multiply(int number) {
        return multiply(new Fraction(number));
    }

    /** Деление на другую дробь (возвращает новую дробь). */
    public Fraction div(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    /** Деление на целое число (возвращает новую дробь). */
    public Fraction div(int number) {
        return div(new Fraction(number));
    }

    /** Возвращает текстовое представление дроби (сокращённое). */
    @Override
    public String toString() {
        // FIX_ME: в исходном коде дроби вроде 2/1 выводились как "2/1", что некрасиво
        // Старый код:
        // return numerator + "/" + denominator;

        // Новый код:
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        return numerator + "/" + denominator;
    }

    /** Форматирует операцию с двумя дробями для вывода. */
    public static String operationToString(Fraction f1, String operator, Fraction f2, Fraction result) {
        return f1 + " " + operator + " " + f2 + " = " + result;
    }

    /** Форматирует операцию с дробью и числом для вывода. */
    public static String operationToString(Fraction f1, String operator, int number, Fraction result) {
        return f1 + " " + operator + " " + number + " = " + result;
    }
}