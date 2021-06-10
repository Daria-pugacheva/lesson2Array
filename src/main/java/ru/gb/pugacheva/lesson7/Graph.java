package ru.gb.pugacheva.lesson7;

public interface Graph {

    void addVertex(String label);

    boolean addEdge (String startLabel, String secondLabel, String... others);

    int getSize ();

    void display ();

    //Depth-first search - DFS - алгоритм поиска в глубину

    void dfs (String startLebel);

    //Breadth-first search - DFS - алгоритм поиска в ширину

    void bfs (String startLebel);




}
