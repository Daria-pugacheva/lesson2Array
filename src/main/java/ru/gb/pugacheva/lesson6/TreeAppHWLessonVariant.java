package ru.gb.pugacheva.lesson6;
// закомментировано, т.к. в других классах тоже данная реализация закомментирована.
//import java.util.Random;
//
//public class TreeAppHWLessonVariant {
//
//    public static void main(String[] args) {
//
//        Random rand = new Random();
//        int treeCount = 20;
//        int maxLevel = 4;
//        int nodeCount = (int) (Math.pow(2, maxLevel) - 1);
//        int maxValue = 25; // от -25 до 25
//        int balsncedTreeCount = 0;
//        boolean treeView = false;
//
//        for (int i = 0; i < treeCount; i++) {
//            Tree<Integer> theTree = new TreeImpl<>(maxLevel);
//            initTree (rand,nodeCount,maxValue, theTree);
//            if(theTree.isBalanced()){
//                balsncedTreeCount++;
//                if(!treeView){
//                    treeView = true;
//                    theTree.display(); // хотим отсмотреть первое сбалансированное дерево . Просто, чтобы убедиться в его сбалансированности.
//
//                }
//            }
//        }
//        System.out.println("Balanced tree count = " + ((balsncedTreeCount/(treeCount*1.0))*100) + "%");
//    }
//
//    private static void initTree (Random rand,int nodeCount,int maxValue,Tree <Integer> theTree){
//        for (int j = 0; j < nodeCount; j++) {
//            theTree.add(rand.nextInt(maxValue*2+1) - maxValue); // это значения от -25 до 25
//        } // naxtInt генерит значения от нуля до параметра минус 1 => если получится случано ноль, то
//        // мы вычитаем maxValue и получаем -25 . Если же получается 25*2 + 1 - т.е. 50 включительно, то
//        // вычитаем опять 25 и получаем 25 максимальное значение.
//    }
//}
