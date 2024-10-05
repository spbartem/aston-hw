package ru.aston.stage1.hw2;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E extends Comparable<E>> {
    private Object[] array;
    private int size = 0;
    private int capacity = 5;

    public MyArrayList() {
        this.array = new Object[capacity];
    }


    // Метод увеличения размера массива
    private void makeArrayGreatAgain(int minCapacity) {
            int newCapacity = minCapacity * 3 / 2 + 1;
            array = Arrays.copyOf(array, newCapacity);
            capacity = newCapacity;
    }

    // Метод проверки необходимости увеличения размера массива
    private void checkCapacity(int minCapacity) {
        if (minCapacity >= capacity) {
            makeArrayGreatAgain(minCapacity);
        }
    }

    // Метод добавления элемента
    public void add(E element) {
        checkCapacity(size + 1);
        array[size++] = element;

    }

    // Метод вставки элемента в массив по индексу со сдвигом вправо остальных элементов
    public void add(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        checkCapacity(size + 1);
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    // Метод добавления элементов внешней коллекции в экземпляр ArrayList
    public boolean addAll(Collection<? extends E> collection) {
        checkCapacity(size + collection.size());
        for (E element : collection) {
            array[size++] = element;
        }
        return true;
    }

    // Метод удаления элемента из списка по указанному индексу
    public E remove(int index) {
        E result;
        if (index >= 0 && index < size) {
            result = (E) array[index];
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        size--;
        return result;
    }

    // Метод получения элемента по указанному индексу в списке
    public E get(int index) {
        if (index >= 0 && index < size) {
            return (E) array[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    // Метод получения длины массива
    public int length() {
        return size;
    }

    // Метод добавления элемента в массив по индексу с заменой значения
    public void set(int index, E elem) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds. Index: " + index + ", " +
                    "Max allowed index: " + (size - 1));
        }
        array[index] = elem;
    }

     // Статический метод сортировки пузырьком
    public static <E extends Comparable<E>> void bubbleSort(MyArrayList<E> arrayList) {
        for (int i = 0; i < arrayList.length(); i++) {
            for (int j = i + 1; j < arrayList.length(); j++) {
                if (arrayList.get(i).compareTo(arrayList.get(j)) > 0) {
                    E temp = arrayList.get(i);
                    arrayList.set(i, arrayList.get(j));
                    arrayList.set(j, temp);
                }
            }
        }
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(array[i]);
            if (i == size - 1) return b.append(']').toString();
            b.append(", ");
        }
    }
}

