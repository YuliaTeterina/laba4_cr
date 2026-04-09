package com.example;

import java.util.ArrayList;
import java.util.List;

/** Сущность Город с путями к другим городам. */
public class City {
    private String name;                 // Название города
    private List<City> connectedCities;  // Список связанных городов
    private List<Integer> travelCosts;   // Список стоимостей поездки

    /** Конструктор по умолчанию (пустое название, без связей). */
    public City() {
        this.name = "";
        this.connectedCities = new ArrayList<>();
        this.travelCosts = new ArrayList<>();
    }

    /** Конструктор только с названием (без связей). */
    public City(String name) {
        // FIX_ME: в исходном коде не было проверки на null для name
        // Старый код:
        // this.name = name;

        // Новый код:
        this.name = (name != null) ? name : "";
        this.connectedCities = new ArrayList<>();
        this.travelCosts = new ArrayList<>();
    }

    /** Конструктор с названием и готовыми связями. */
    public City(String name, List<City> cities, List<Integer> costs) {
        // FIX_ME: в исходном коде не было проверки на null для name
        // Старый код:
        // this.name = name;

        // Новый код:
        this.name = (name != null) ? name : "";
        this.connectedCities = new ArrayList<>();
        this.travelCosts = new ArrayList<>();

        if (cities != null && costs != null && cities.size() == costs.size()) {
            for (int i = 0; i < cities.size(); i++) {
                if (cities.get(i) != null) {
                    this.connectedCities.add(cities.get(i));
                    this.travelCosts.add(costs.get(i));
                }
            }
        }
    }

    /** Возвращает название города. */
    public String getName() {
        return name;
    }

    /** Возвращает список связанных городов. */
    public List<City> getConnectedCities() {
        return connectedCities;
    }

    /** Возвращает список стоимостей поездки. */
    public List<Integer> getTravelCosts() {
        return travelCosts;
    }

    /** Добавляет путь к другому городу с указанной стоимостью. */
    public void addPath(City city, int cost) {
        // FIX_ME: в исходном коде не было проверки на отрицательную стоимость
        // Старый код:
        // if (city != null && !connectedCities.contains(city)) {
        //   connectedCities.add(city);
        //   travelCosts.add(cost);
        // }

        // Новый код:
        if (city != null && !connectedCities.contains(city) && cost >= 0) {
            connectedCities.add(city);
            travelCosts.add(cost);
        }
    }

    /** Возвращает текстовое представление города и его путей. */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Город: ").append(name);

        if (!connectedCities.isEmpty()) {
            result.append("\nПути: ");
            for (int i = 0; i < connectedCities.size(); i++) {
                if (i > 0) {
                    result.append(", ");
                }
                result.append(connectedCities.get(i).getName())
                        .append("(").append(travelCosts.get(i)).append(")");
            }
        } else {
            // FIX_ME: в исходном коде при отсутствии путей ничего не выводилось
            // Старый код: ничего не выводил

            // Новый код:
            result.append("\nПути: нет");
        }

        return result.toString();
    }
}