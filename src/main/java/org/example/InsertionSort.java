package org.example;
/*
Сортировка вставкой (Insertion Sort)
Проводим итерацию по массиву и сравниваем текущий элемент (ключ) с предшествующим.
Если ключевой элемент меньше предшественника, то сравниваем его с элементами, расположенными перед предшественником.
Перемещаем большие элементы на одну позицию вверх, чтобы создать место для переставляемого элемента.

Сложность алгоритма: О(n2)
 */

public class InsertionSort implements iSortStrategy{
    @Override
    public int[] sort(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return numbers; // Возвращаем массив, если он пуст или содержит один элемент
        }

        int[] sorted = numbers.clone();
        int j;
        for (int i = 1; i < sorted.length; i++) {
            int key = sorted[i];
            j = i;
            while (j > 0 && sorted[j - 1] > key) {
                sorted[j] = sorted[j - 1];
                j--;
            }
            sorted[j] = key;
        }
        return sorted;
    }
}
