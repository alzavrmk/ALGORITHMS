package ru.geekbrains.lesson2;

public class SortUtils {

    /**
     * Сортировка выбором
     *
     * 0 1 2 3 4
     *
     * 5 4 1 0 1
     *
     * @param array
     */
    public static void directSort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            int saveIndex = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[saveIndex]){
                    saveIndex = j;
                }
            }

            if (saveIndex != i){
                int buf = array[i];
                array[i] = array[saveIndex];
                array[saveIndex] = buf;
            }

        }
    }

    public static void quickSort(int[] array){
        if (array == null)
            return;
        quickSort(array, 0, array.length - 1);
    }
    /**
     * Быстрая сортировка
     */

    private static void quickSort(int[] array, int start, int end){

        int left = start;
        int right = end;
        int middle = array[(start + end) / 2]; // значение опорного элемента

        do {
            while (array[left] < middle){
                left++;
            }

            while (array[right] > middle){
                right--;
            }

            if (left <= right){
                if (left < right){
                    int buf = array[left];
                    array[left] = array[right];
                    array[right] = buf;
                }
                left++;
                right--;
            }
        }
        while (left <= right);

        if (left < end){
            quickSort(array, left, end);
        }

        if (start < right){
            quickSort(array, start, right);
        }


    }

    public static void sortPyramid(int[] array){
        // Построение кучи
        for (int i = array.length/2-1; i>=0; i--)
            heapyfy(array, array.length, i);


        //наибольший элемент с нулевым индексом, полученный в результате
        //реботы метода heapyfy помещаем с 0 позиции в конец массива
        for (int i = array.length-1; i>=0; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

        //Вызываем метод   heapyfy на уменьшенной куче
            heapyfy(array, array.length, i);
        }

    }
    private static void heapyfy(int[] array, int heapSize, int rootIndex){
        int largest = rootIndex; //Инициализируем наибольший элемент как корень
        int leftChild = 2*rootIndex +1;
        //Запоминаем индекс левого ребенка относительно элемента rootIndex в переменную leftChild
        int rigthChild = 2*rootIndex +2;
        //Запоминаем индекс правого ребенка относительно элемента rootIndex в переменную rigthChild

        //Если левый дочерний элемент больше корня и его индекс не больше текущей длины массива
        // то запоминаем этот индекс в переменную largest
        if (leftChild < heapSize && array[leftChild]> array[largest])
            largest = leftChild;

        //Если правый дочерний элемент больше корня и его индекс не больше текущей длины массива
        // то запоминаем этот индекс в переменную largest
        if (rigthChild < heapSize && array[rigthChild]> array[largest])
            largest = rigthChild;

        // Если самый большой элемент не корень то помещаем его на место корня
        if (largest != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapyfy(array, heapSize, largest);
        }



    }

}
