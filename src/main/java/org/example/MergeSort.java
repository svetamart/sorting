package org.example;

/* Сортировка слиянием (Merge Sort)
Алгоритм разбивает список на две части, каждую из них он разбивает ещё на две и так далее, пока не останутся единичные элементы.
Массив из одного элемента считается упорядоченным.
Соседние элементы сравниваются и соединяются вместе. Так происходит до тех пор, пока все элементы не будут отсортированы.


Сложность алгоритма: O(n log n)
 */

public class MergeSort implements iSortStrategy{
    @Override
    public int[] sort(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return numbers; // Возвращаем массив, если он пуст или содержит один элемент
        }
        int[] sorted = numbers.clone();
        mergeSort(sorted, 0, sorted.length - 1); // Вызываем рекурсивный метод для сортировки
        return sorted;
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle); // Рекурсивная сортировка левой половины
            mergeSort(arr, middle + 1, right); // Рекурсивная сортировка правой половины
            merge(arr, left, middle, right); // Слияние двух отсортированных половин
        }
    }

    private void merge(int[] arr, int left, int middle, int right) {
        int leftBorder = middle - left + 1;
        int rightBorder = right - middle;

        int[] leftArray = new int[leftBorder];
        int[] rightArray = new int[rightBorder];

        for (int i = 0; i < leftBorder; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < rightBorder; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < leftBorder || j < rightBorder) {
            if (i < leftBorder && (j >= rightBorder || leftArray[i] <= rightArray[j])) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
    }
}
