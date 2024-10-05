package ru.aston.stage1.hw2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();

        System.out.println("======= add =======");
        myArrayList.add("A");
        myArrayList.add("B");
        myArrayList.add("C");
        System.out.println(myArrayList.get(2));
        printArray(myArrayList);

        System.out.println("\n======= add with index =======");
        myArrayList.add(2, "F");
        System.out.println(myArrayList.get(2));
        printArray(myArrayList);

        System.out.println("\n======= set =======");
        myArrayList.set(0, "D");
        System.out.println(myArrayList.get(0));
        printArray(myArrayList);
        System.out.println("Array's size: " + myArrayList.length());

        System.out.println("\n======= add all =======");
        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "E", "I", "J", "H", "K", "L", "D", "U", "Q","L", "V", "Z","S", "O", "w","f", "R", "5");
        boolean result = myArrayList.addAll(new ArrayList<>(collection));
        if (result) System.out.println(myArrayList);
        System.out.println("Array's size: " + myArrayList.length());

        System.out.println("\n======= sort =======");
        MyArrayList.bubbleSort(myArrayList);
        System.out.println(myArrayList);

        System.out.println("\n======= remove =======");
        myArrayList.remove(5);
        printArray(myArrayList);
        System.out.println("Array's size: " + myArrayList.length());

        System.out.println("\n======= length =======");
        System.out.println(myArrayList.length());
    }

    public static void printArray(MyArrayList<String> myArrayList) {
        System.out.println(myArrayList);
    }
}
