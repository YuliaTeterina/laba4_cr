package com.example;

/** Сущность Точка на двумерной плоскости. */
public class Point {
    private double x; // Координата X
    private double y; // Координата Y

    /** Конструктор по умолчанию (точка в начале координат). */
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    /** Конструктор с координатами. */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /** Возвращает координату X. */
    public double getX() {
        return x;
    }

    /** Устанавливает координату X. */
    public void setX(double x) {
        this.x = x;
    }

    /** Возвращает координату Y. */
    public double getY() {
        return y;
    }

    /** Устанавливает координату Y. */
    public void setY(double y) {
        this.y = y;
    }

    /** Возвращает текстовое представление точки в формате {X;Y}. */
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}