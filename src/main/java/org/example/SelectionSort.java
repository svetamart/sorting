package org.example;
/*
Сортировка выбором (Selection Sort)
Разбиваем массив на отсортированную и неотсортированную части.
Находим в неотсортированной части минимальный элемент и смещаем его в самое начало.
Далее находим следующий по величине элемент и меняем его с элементом на первой позиции, etc., пока не закончатся неотсортированные значения.

Сложность алгоритма: О(n2)
*/

public class SelectionSort implements iSortStrategy{

    @Override
    public int[] sort(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return numbers; // Возвращаем массив, если он пуст или содержит один элемент
        }

        int[] sorted = numbers.clone();
        for (int i = 0; i < sorted.length; i++) {
            int pos = i;
            int min = sorted[i];
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[j] < min) {
                    pos = j;
                    min = sorted[j];
                }
            }
            sorted[pos] = sorted[i];
            sorted[i] = min;
        }
        return sorted;
    }
}
