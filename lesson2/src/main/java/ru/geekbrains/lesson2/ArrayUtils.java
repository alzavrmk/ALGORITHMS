package ru.geekbrains.lesson2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Утилиты для работы с массивами
 */
public class ArrayUtils {

    private static Random random = new Random();

    /**
     * Подготовить массив случайных чисел как бы конструктор без аргументов
     * количество элеменетов в массиве определяется случайным образом и определяется
     * диапозоном от 10 до 15
     * @return
     */
    public static int[] prepareArray(){

        return prepareArray(random.nextInt(10, 15));
    }

    /**
     * Подготовить массив случайных чисел, количество элементов - входной аргумент метода
     * @return
     */
    public static int[] prepareArray(int length){
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(-99, 100);
        }
        return array;
    }

    /**
     * Распечатать массив на консоль
     * @param array
     */
    public static void printArray(int[] array){
        for (int e: array) {
            System.out.printf("%d\t", e);
        }
        System.out.println();
    }

}

class MyArrayList{

    private static final int CAPACITY = 1000;
    private int lastIndex = -1;

    private int[] array;

    public MyArrayList(){
        array = new int[CAPACITY];
    }

    public MyArrayList(int capacity){
        array = new int[capacity];
    }

    public void Add(int element){
        array[++lastIndex] = element;
    }

    public int size(){
        return lastIndex + 1;
    }

}