package ru.gb.pugacheva.lesson6;

public class Test6 {

    public static void main(String[] args) {
        Tree <Integer> tree = new TreeImpl<>(100);
        tree.add(60);
        tree.add(50);
        tree.add(66);
        tree.add(40);
        tree.add(55);
        tree.add(70);
        tree.add(31);
        tree.add(45);
        tree.add(42);
        tree.add(43);
        tree.add(67);
        tree.add(81);

//        System.out.println("Contains 70: " + tree.contains(70));
//        System.out.println("Contains 700: " + tree.contains(700));
//
//        tree.traverse(Tree.TraverseMode.IN_ORDER);

        tree.display();



//        tree.remove(55);
//        tree.remove(42);
//        tree.remove(40);
//        tree.display();
    }
}
