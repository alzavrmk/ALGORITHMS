package ru.geekbrains.lesson2;

import java.util.Arrays;

public class Program {

    public static void main(String[] args) {

        int[] array1 = ArrayUtils.prepareArray(5);
        ArrayUtils.printArray(array1);
        System.out.println("Сортировка выбором\n");
        SortUtils.directSort(array1);
        ArrayUtils.printArray(array1);
        System.out.println();
        array1 = ArrayUtils.prepareArray();
        ArrayUtils.printArray(array1);
        System.out.println("Быстрая сортировка\n");
        SortUtils.quickSort(array1);
        ArrayUtils.printArray(array1);


        array1 = new int[] {5, 4, 1, 0, 1};
        ArrayUtils.printArray(array1);
        SortUtils.quickSort(array1);
        ArrayUtils.printArray(array1);

        array1 = new int[] {5, 4, 1, 0, 1};
        ArrayUtils.printArray(array1);
        System.out.println("Пирамидальная сортировка\n");
        SortUtils.sortPyramid(array1);
        ArrayUtils.printArray(array1);


        array1 = new int[] {4, 12, -1, 0, -55, 17, 90, 23};
        SortUtils.quickSort(array1);
        ArrayUtils.printArray(array1);
        int searchElement = 17;

        int res = Arrays.binarySearch(array1, searchElement);

        //int res = SearchUtils.binarySearch(array1, searchElement);
        System.out.printf("Элемент %d %s\n", searchElement,
                res >= 0 ? String.format("найден в массиве по индексу %d", res) : "не найден в массиве");



        array1 = ArrayUtils.prepareArray(200000);

        long startTime = System.currentTimeMillis();
        SortUtils.directSort(array1.clone());
        long endTime = System.currentTimeMillis();
        System.out.printf("Время работы сортировки выбором: %d мс.\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        SortUtils.quickSort(array1.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время работы быстрой сортировки: %d мс.\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        SortUtils.quickSort(array1.clone());
        endTime = System.currentTimeMillis();

        System.out.printf("Время работы быстрой сортировки: %d мс.\n", endTime - startTime);
        startTime = System.currentTimeMillis();
        SortUtils.quickSort(array1.clone());

        endTime = System.currentTimeMillis();
        System.out.printf("Время работы быстрой сортировки: %d мс.\n", endTime - startTime);
        startTime = System.currentTimeMillis();
        SortUtils.quickSort(array1.clone());
        endTime = System.currentTimeMillis();

        System.out.printf("Время работы быстрой сортировки: %d мс.\n", endTime - startTime);
        startTime = System.currentTimeMillis();
        SortUtils.quickSort(array1.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время работы быстрой сортировки: %d мс.\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        Arrays.sort(array1.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время работы сортировки методом sort: %d мс.\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        SortUtils.sortPyramid(array1.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время работы пирамидальной сортировки: %d мс.\n", endTime - startTime);



    }
}
