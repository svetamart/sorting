package org.example;
/*
Сортировка пузырьком (Bubble Sort)
Суть алгоритма состоит в последовательном сравнении двух соседних элементов.
В том случае, если предыдущий элемент больше последующего, они меняются местами.

Сложность алгоритма: О(n2)
 */

public class BubbleSort implements iSortStrategy{
    @Override
    public int[] sort(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return numbers; // Возвращаем массив, если он пуст или содержит один элемент
        }
        int[] sorted = numbers.clone();
        int temp;
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = 0; j < sorted.length - i - 1; j++) {
                if (sorted[j] > sorted[j + 1]) {
                    temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        return sorted;
    }

    public int[][] matrixSort(int[][] matrix){
        int temp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    for (int l = 0; l < matrix[k].length; l++) {
                        if (matrix[i][j] <= matrix[k][l]) {
                            temp = matrix[i][j];
                            matrix[i][j] = matrix[k][l];
                            matrix[k][l] = temp;
                        }
                    }
                }
            }
        }
        return matrix;
    }
}
