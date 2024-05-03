
package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[rand.nextInt(31)];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(-100, 101);
        }

        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        HeapSort heapSort = new HeapSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        ShellSort shellSort = new ShellSort();

        int[] bubble = bubbleSort.sort(numbers);
        int[] selection = selectionSort.sort(numbers);
        int[] insertion = insertionSort.sort(numbers);
        int[] heap = heapSort.sort(numbers);
        int[] merge = mergeSort.sort(numbers);
        int[] quick = quickSort.sort(numbers);
        int[] shell = shellSort.sort(numbers);


        System.out.println("Исходный массив: " + Arrays.toString(numbers));
        System.out.println("Сортировка пузырьком: " + Arrays.toString(bubble));
        System.out.println("Сортировка выбором: " + Arrays.toString(selection));
        System.out.println("Сортировка вставками: " + Arrays.toString(insertion));
        System.out.println("Сортировка кучей: " + Arrays.toString(heap));
        System.out.println("Сортировка слиянием: " + Arrays.toString(merge));
        System.out.println("Быстрая сортировка: " + Arrays.toString(quick));
        System.out.println("Сортировка Шелла: " + Arrays.toString(shell));
        

        // Сортировка подсчётом (Counting Sort) и Поразрядная сортировка (Radix Sort)


    }
}
