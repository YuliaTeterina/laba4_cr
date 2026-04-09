package com.example;

/** Сущность Линия на двумерной плоскости. */
public class Line {
    private Point start; // Начальная точка линии
    private Point end;   // Конечная точка линии

    /** Конструктор по умолчанию (линия из точки {0;0} в точку {0;0}). */
    public Line() {
        this.start = new Point();
        this.end = new Point();
    }

    /** Конструктор с точками начала и конца. */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /** Конструктор с координатами начала и конца. */
    public Line(double startX, double startY, double endX, double endY) {
        this.start = new Point(startX, startY);
        this.end = new Point(endX, endY);
    }

    /** Возвращает начальную точку линии. */
    public Point getStart() {
        return start;
    }

    /** Устанавливает начальную точку линии. */
    public void setStart(Point start) {
        this.start = start;
    }

    /** Возвращает конечную точку линии. */
    public Point getEnd() {
        return end;
    }

    /** Устанавливает конечную точку линии. */
    public void setEnd(Point end) {
        this.end = end;
    }

    /** Возвращает текстовое представление линии. */
    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}