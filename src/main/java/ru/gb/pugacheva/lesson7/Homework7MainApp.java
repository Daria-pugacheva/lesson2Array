package ru.gb.pugacheva.lesson7;

import java.util.ArrayList;
import java.util.Collections;

public class Homework7MainApp {

    public static void main(String[] args) {

        findShortWay();

    }

    private static void findShortWay() {

        GraphImpl graph = createGraph();

        graph.addEdge("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Липецк", "Воронеж");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Саратов", "Воронеж");
        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Орел", "Курск");
        graph.addEdge("Курск", "Воронеж");

        System.out.println("Последовательность обхода в ширину:");
        graph.findShortWayByBfs("Москва", "Воронеж"); // обошли в ширину
        ArrayList<String> arrayList = graph.getAllLabelsInBfsQueue(); // собрали в лист города в последовательности обхода
        System.out.println("Последовательность обхода до перемещения цикла на второе кольцо обхода");
        int step = graph.queueLengthBeforeFirstRemove("Москва", "Воронеж"); // получили шаг, через который делаем обход по каждому варианту пути
        ArrayList<String> bestWay = new ArrayList<>();
        int indexOfFinish = arrayList.indexOf("Воронеж");

        for (int i = indexOfFinish; i > 0; i -= step) {
            bestWay.add(arrayList.get(i));
        }
        bestWay.add(arrayList.get(0));

        Collections.reverse(bestWay);
        System.out.println("Кратчайший путь : " + bestWay);

    }

    private static GraphImpl createGraph() {
        GraphImpl cities = new GraphImpl(10);
        cities.addVertex("Москва");
        cities.addVertex("Тула");
        cities.addVertex("Липецк");
        cities.addVertex("Воронеж");
        cities.addVertex("Рязань");
        cities.addVertex("Тамбов");
        cities.addVertex("Саратов");
        cities.addVertex("Калуга");
        cities.addVertex("Орел");
        cities.addVertex("Курск");


        return cities;
    }
}
