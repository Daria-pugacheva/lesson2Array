package ru.gb.pugacheva.lesson6;

public class HomeWork6MainApp {

    public static void main(String[] args) {

        System.out.println("20 деревьев с глубиной в 4 уровня, случайный диапазон от -25 до 25: ");
       createTree(20,4,-25,25);

        System.out.println();

        System.out.println("20 деревьев с глубиной в 6 уровней, случайный диапазон от -100 до 100: ");
        createTree(20,6,-100,100);

    }

    public static void createTree (int treeQuantity, int maxLevelNumber, int lowRandomLimit, int highRandomLimit){
        int balancedTreeQuantity=0;
        for (int i = 1; i <=treeQuantity; i++) {
            TreeImpl <Integer> tree = new TreeImpl<>(maxLevelNumber);
            for (int j = 0; j <= (Math.pow(2,maxLevelNumber)-1); j++) {
                tree.add((int) (Math.random()*(highRandomLimit-lowRandomLimit)+lowRandomLimit)); //Math.random() * (high-low) ) + low
            }
            if (isBalanced(tree.getRoot())){
                balancedTreeQuantity++;
            }
        }

        int percent = balancedTreeQuantity*100/treeQuantity;

        System.out.println("Количество сбалансированных деревьев=" + balancedTreeQuantity + "" +
                "\n Процент сбалансированных деревьев = " + percent + "%");
    }

    public static boolean isBalanced(Node <Integer> node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node <Integer> node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

}
