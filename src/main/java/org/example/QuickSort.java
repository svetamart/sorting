package org.example;
/*
Быстрая сортировка (Quick Sort)
Из массива выбирается опорный элемент, чаще всего посередине массива.
Другие элементы массива распределяются таким образом, чтобы меньшие размещались до него, а большие — после.
Далее рекурсивно применяем сортировку к подмассивам, которые разделились опорным элементом на две части — слева и справа от него.

Сложность алгоритма: O(n log n)
*/

public class QuickSort implements iSortStrategy{

    @Override
    public int[] sort(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return numbers; // Возвращаем массив, если он пуст или содержит один элемент
        }
        int[] sorted = numbers.clone();
        quickSort(sorted, 0, sorted.length - 1); // Вызываем метод быстрой сортировки
        return sorted;
    }

    private void quickSort(int[] numbers, int low, int high) {
        if (low >= high) return;

        // Выбираем опорный элемент
        int middle = (high + low) / 2;
        int pivot = numbers[middle];

        int leftBorder = low, rightBorder = high;
        while (leftBorder <= rightBorder) {
            // Двигаем левый маркер (low) слева направо, пока элемент меньше, чем pivot
            while (numbers[leftBorder] < pivot) leftBorder++;
            // Двигаем правый маркер (high), пока элемент больше, чем pivot
            while (numbers[rightBorder] > pivot) rightBorder--;
            if (leftBorder <= rightBorder) {
                if (leftBorder < rightBorder) {
                    int temp = numbers[leftBorder];
                    numbers[leftBorder] = numbers[rightBorder];
                    numbers[rightBorder] = temp;
                }
                    leftBorder++;
                    rightBorder--;
                }
        }

        // Рекурсия для сортировки левой и правой части
        if (low < rightBorder) {
            quickSort(numbers, low, rightBorder);
        }
        if (high > leftBorder) {
            quickSort(numbers, leftBorder, high);
        }
    }
}
