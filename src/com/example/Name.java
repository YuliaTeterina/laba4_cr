package com.example;

/** Сущность Имя с фамилией, именем и отчеством. */
public class Name {
    private String lastName;  // Фамилия
    private String firstName; // Личное имя
    private String middleName; // Отчество

    /** Конструктор по умолчанию (все поля пустые). */
    public Name() {
        this.lastName = "";
        this.firstName = "";
        this.middleName = "";
    }

    /** Конструктор со всеми параметрами: фамилия, имя, отчество. */
    public Name(String lastName, String firstName, String middleName) {
        // FIX_ME: в исходном коде не было проверки на null
        // Старый код:
        // this.lastName = lastName;
        // this.firstName = firstName;
        // this.middleName = middleName;

        // Новый код:
        this.lastName = (lastName != null) ? lastName : "";
        this.firstName = (firstName != null) ? firstName : "";
        this.middleName = (middleName != null) ? middleName : "";
    }

    /** Конструктор только с фамилией и именем (отчество не задано). */
    public Name(String lastName, String firstName) {
        this(lastName, firstName, "");
    }

    /** Конструктор только с именем и отчеством (фамилия не задана). */
    public Name(String firstName, String middleName, boolean dummy) {
        this("", firstName, middleName);
    }

    /** Конструктор только с именем (фамилия и отчество не заданы). */
    public Name(String firstName) {
        this("", firstName, "");
    }

    /** Возвращает текстовое представление имени (только заданные поля через пробел). */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (lastName != null && !lastName.isEmpty()) {
            result.append(lastName);
        }

        if (firstName != null && !firstName.isEmpty()) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(firstName);
        }

        if (middleName != null && !middleName.isEmpty()) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(middleName);
        }

        return result.toString();
    }
}