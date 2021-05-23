package ru.gb.pugacheva.lesson2;

public class SortedArray<E extends Comparable<? super E>> extends DynamicArray<E> {

    @Override
    public int indexOf(E value) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid].equals(value)) {
                return mid;
            } else if (value.compareTo(data[mid]) > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    @Override
    public void add(E value) {  // альтернативный вариант метода для добавления сразу с сортировкой
        checkAndGrow();
        int index = size();
        for (int i = 0; i < size(); i++) {
            if (data[i].compareTo(value) > 0) {
                index = i;
                break;
            }
        }
        if (index == size) {  //а ведь index == size - Это за пределами заполненного массива?(еще раз смотреть)
            data[size++] = value;
        } else {
            doInsert(index, value);
        }
    }

    private void doInsert(int index, E value) {
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }
}
