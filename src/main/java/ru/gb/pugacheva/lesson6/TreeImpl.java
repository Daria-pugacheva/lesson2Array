package ru.gb.pugacheva.lesson6;

import ru.gb.pugacheva.lesson4.LinkedList;

import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private class NodeAndParent {
        private Node<E> current;
        private Node<E> parent;

        public NodeAndParent(Node<E> current, Node<E> parent) {
            this.current = current;
            this.parent = parent;
        }
    }

    private int size;

    private Node<E> root;

    private final int maxLevelNumber;

    private int currentLevel;

    public TreeImpl(int maxLevelNumber) {  //в конструкторе задаем максимальное число уровней дерева
        this.maxLevelNumber=maxLevelNumber;
    }

    public Node<E> getRoot() {
        return root;
    }

    @Override
    public boolean add(E value) {
//        Node <E> current = root;
//        Node <E> previous = null;
//        Node <E> node = new Node<>(value);
//
//        while (current!=null){
//            if(current.getValue().equals(value)){
//                return false;
//            }
//
//            previous=current;
//            if(current.isLeftChild(value)){
//                current=current.getLeftChild();
//            }else {
//                current=current.getRightChild();
//            }
//        }

        /// заменяем на реализацию с doFind

        Node<E> node = new Node<>(value);
        NodeAndParent nodeAndParent = doFind(value);
      //  System.out.println(currentLevel); // ВРЕМЕННО ДЛЯ ПРОВЕРКИ!!!!!!!!!!!

        if (nodeAndParent.current != null || currentLevel>maxLevelNumber) { //добавлена проверка про уровень
            return false;
        }
        Node<E> previous = nodeAndParent.parent;

        if (previous == null) {
            root = node;
        } else if (previous.isLeftChild(value)) {
            previous.setLeftChild(node);
        } else {
            previous.setRightChild(node);
        }

        size++;
        return true;
    }


    @Override
    public boolean contains(E value) {
//        Node <E> current = root;
//        while (current!=null){
//            if(current.getValue().equals(value)){
//                return true;
//            }
//
//            if(value.compareTo(current.getValue()) < 0){
//                current=current.getLeftChild();
//            }else {
//                current=current.getRightChild();
//            }
//        }
//        return false;
        ////заменяем вышеописанный код на логику с doFind
        NodeAndParent nodeAndParent = doFind(value);
        return nodeAndParent.current != null;
    }

    private NodeAndParent doFind(E value) {
        Node<E> current = root;
        Node<E> previous = null;
        currentLevel=1; //когда появляется root, то это самый первый уровень

        while (current != null) {
            if (current.getValue().equals(value)) {
                return new NodeAndParent(current, previous);
            }

            previous = current;
            if (current.isLeftChild(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
            currentLevel++; //по мере следования по веткам вниз, уровень растет
        }

        return new NodeAndParent(null, previous);
    }

    @Override
    public boolean remove(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> removedNode = nodeAndParent.current;
        Node<E> parentNode = nodeAndParent.parent;

        if (removedNode == null) {
            return false;
        }

        if (removedNode.isLeaf()) {
            removeLeafNode(removedNode, parentNode);
        } else if (removedNode.hasOnlyOneChild()) {
            removeNodeWithOnlyOneChild(removedNode, parentNode);
        } else {
            removeNodeWithAllChildren(removedNode,parentNode);
        }
        size--;
        return true;
    }

    private void removeNodeWithAllChildren(Node<E> removedNode, Node<E> parentNode) {
        Node<E> successor = getSuccessor(removedNode);
        if (removedNode == root) {
            root = successor;
        } else if (parentNode.isLeftChild(removedNode.getValue())) {
            parentNode.setLeftChild(successor);
        } else {
            parentNode.setRightChild(successor);
        }

        successor.setLeftChild(removedNode.getLeftChild());
    }

    private Node<E> getSuccessor(Node<E> removedNode) {
        Node<E> succesor = removedNode;
        Node<E> successorParent = null;
        Node<E> current = removedNode.getRightChild();

        while (current != null) {
            successorParent = succesor;
            succesor = current;
            current = current.getLeftChild();
        }

        if (succesor != removedNode.getRightChild() && successorParent != null) {
            successorParent.setLeftChild(succesor.getRightChild());
            succesor.setRightChild(removedNode.getRightChild());
        }
        return succesor;
    }

    private void removeLeafNode(Node<E> removedNode, Node<E> parentNode) {
        if (removedNode == root) {
            root = null;
        } else if (parentNode.isLeftChild(removedNode.getValue())) {
            parentNode.setLeftChild(null);
        } else {
            parentNode.setRightChild(null);
        }
    }

    private void removeNodeWithOnlyOneChild(Node<E> removedNode, Node<E> parentNode) {
        Node<E> childNode = removedNode.getLeftChild() != null
                ? removedNode.getLeftChild()
                : removedNode.getRightChild();
        if (removedNode == root) {
            root = childNode;
        } else if (parentNode.isLeftChild(removedNode.getValue())) {
            parentNode.setLeftChild(childNode);
        } else {
            parentNode.setRightChild(childNode);
        }
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown treverse mode " + mode);
        }
    }

    private void inOrder(Node<E> current) {
        if (current == null) {
            return;
        }
        inOrder(current.getLeftChild());
        System.out.println(current.getValue());
        inOrder(current.getRightChild());
    }

    private void preOrder(Node<E> current) {
        if (current == null) {
            return;
        }
        System.out.println(current.getValue());
        preOrder(current.getLeftChild());
        preOrder(current.getRightChild());
    }

    private void postOrder(Node<E> current) {
        if (current == null) {
            return;
        }
        postOrder(current.getLeftChild());
        postOrder(current.getRightChild());
        System.out.println(current.getValue());
    }


    @Override
    public boolean isEmpty() {
        return root==null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        Stack <Node <E>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;
        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty){
            Stack <Node<E>> localStack = new Stack<>();

            isRowEmpty=true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()){
                Node <E> tempNode = globalStack.pop();
                if(tempNode!=null){
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if(tempNode.getLeftChild()!=null || tempNode.getRightChild()!=null) {
                        isRowEmpty = false;
                    }
                    }else {
                        System.out.print("--");
                        localStack.push(null);
                        localStack.push(null);
                    }
                    for (int j = 0; j < nBlanks*2 - 2; j++) {
                        System.out.print(" ");
                    }
                }
                System.out.println();

                while (!localStack.isEmpty()){
                    globalStack.push(localStack.pop());
                }
                nBlanks/=2;
            }
            System.out.println("................................................................");
        }


    }


