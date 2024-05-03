package org.example;
/*
Сортировка Шелла (SHell Sort)
Улучшенный вариант сортировки вставками.
Сравниваем элементы, находящиеся на определенном расстоянии друг от друга,
а затем постепенно уменьшаем это расстояние, пока не произойдет сортировка всего массива.

Сложность алгоритма: O(n log n)
 */

public class ShellSort implements iSortStrategy{
    @Override
    public int[] sort(int[] numbers) {
        int[] arr = numbers.clone();
        int n = arr.length;

        // Начинаем с большого шага, затем постепенно его уменьшаем
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Применяем сортировку вставками с шагом gap
            for (int i = gap; i < n; i++) {
                int key = arr[i];
                int j = i;

                // Сравниваем элементы на расстоянии gap и перемещаем их, если необходимо
                while (j >= gap && arr[j - gap] > key) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = key;
            }
        }
        return arr;
    }
}
