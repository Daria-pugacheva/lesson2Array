package ru.gb.pugacheva.lesson4;

public class TwoSideLinkedListForDekImpl <E> extends TwoSideLinkedListImpl <E> implements TwoSideLinkedList <E>{



    @Override
    public void insertFirst(E value) {
        firstElement=new Node<E>(value, firstElement, null);
        if(size==1){
            lastElement=firstElement;
        }
        size++;

    }

    @Override
    public void insertLast(E value) {
        Node <E> newNode = new Node<>(value,null, lastElement);
        if(isEmpty()){
            firstElement=newNode;
        } else {
            lastElement.next=newNode;
        }
        lastElement=newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node <E> removedNode = firstElement;
        firstElement=removedNode.next;  // первым стал второй элемент
        removedNode.next=null;  // обнулили ссылку на следующий у удаленного эл-та
        firstElement.previous=null; // для нового первого элемента предыдущий обнулили
        if (isEmpty()){
            lastElement=null;
        }
        size--;
        return removedNode.item;
    }

    public E removeLast() {  // добавлен метод по удалению последнего элемента
        if (isEmpty()) {
            return null;
        }
        Node <E> removedNode = lastElement;
        lastElement=removedNode.previous;  // последним стал предпоследний
        removedNode.previous=null;  // обнулили ссылку на предыдущий у удаленного эл-та
        lastElement.next=null; // для нового последнего элемента следущий обнулили
        if (isEmpty()){
            firstElement=null;
        }
        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node <E> current = firstElement;
        while (current != null){
            if(current.item.equals(value)){
                break;
            }
            current.previous=current;
            current=current.next;
        }

        if (current==null){
            return false;
        }else if (current==firstElement){
            removeFirst();
            return  true;
        }else if(current==lastElement) {
            removeLast();
            return true;
        }else {
            current.previous.next=current.next;
            current.next.previous=current.previous;
        }
        current.next=null;
        current.previous=null;
        size--;
        return true;
    }


}
