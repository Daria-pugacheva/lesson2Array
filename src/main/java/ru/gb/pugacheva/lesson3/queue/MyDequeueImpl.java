package ru.gb.pugacheva.lesson3.queue;

public class MyDequeueImpl<E> implements MyDequeue<E> {

    private final E[] data;
    private int size;

    private static final int HEAD_DEFAULT = 0;
    private static final int TAIL_DEFAULT = -1;

    private int tail;
    private int head;

    @SuppressWarnings("unchecked")
    public MyDequeueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = HEAD_DEFAULT;
        this.tail = TAIL_DEFAULT;
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }
        if (head > 0) {  //если голова не в началe массива,т.е. слева от нее свободно просто вставляем значение слева и декрементируем head
//            data[head-1]=value;
//            head--;
            data[--head] = value;
        } else {
            for (int i = tail; i >= head; i--) {
                data[i + 1] = data[i]; //сдвигаем все значения на одну позицию вправо
            }
            data[head] = value; // на место и индексом головы кладем новое значение
            tail++; //просто инкрементируем хвост, т.к. если голова на нулевом индексе массив не полный, то хвост точно не напоследней позиции.
        }
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == data.length - 1) {
            tail = TAIL_DEFAULT;
        }

        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }
        // data[head]=null; - в нашем контексте, вроде, не надо, но смущает, что не обнуляем
        // типа когда очередь все время перезаписывает на пустые индексы вновь прибывших, так сказать,
        // то и нет лишних ссылок, а если мы сделали remove, а в очередь никто больше не просится...
        // Возможно, я немного подазпуталась, и тут нет нужды обнуляться, т.к. все равно массив
        // хранится в памяти... В общем, есть какие-то сомнения у меня тут

        if (head == data.length) {
            head = HEAD_DEFAULT;
        }
        E value = data[head];
        head++;
        size--;

        return value;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        E value = data[tail];
        //data[tail]=null; // те же переживания, что описаны на строках 61-65 :/
        if (tail == 0) {
            tail = size - 1;
        } else {
            tail--;
        }
        size--; // можно сократить код, сдалев строку 77 tail=--size;, но так читабельнее
        return value;
    }

    @Override
    public E peekFront() {
        return data[head];
    }

    @Override
    public E peekTail() {
        return data[tail];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = head; i <= tail; i++) {
            sb.append(data[i]);
            if (i < tail) {
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

    public void display() {
        System.out.println(this);
    }
}
