package org.example;

/*
Пирамидальная сортировка (Heap Sort)
Алгоритм использует структуру данных "куча" для упорядочивания элементов массива.
Сначала преобразуем массив в кучу (или "двоичное дерево"), где каждый элемент имеет приоритет по сравнению с его потомками (больше или меньше своих потомков).
Затем извлекаем максимальный элемент из корня кучи и помещаем его в конец массива.
Перестраиваем кучу и извлекаем следующий максимальный элемент, повторяя этот процесс, пока не упорядочим весь массив.

Сложность алгоритма: O(n log n)
 */

public class HeapSort implements iSortStrategy{
    @Override
    public int[] sort(int[] numbers) {
        int[] array = numbers.clone();
        int length = numbers.length;

        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(array, length, i); // Строим кучу

        // Извлекаем элементы из кучи
        for (int i = length - 1; i > 0; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            heapify(array, i, 0);
        }
        return array;
    }

    void heapify(int[] array, int length, int i)
    {
        int greatest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < length && array[left] > array[greatest])
            greatest = left;

        if (right < length && array[right] > array[greatest])
            greatest = right;

        // Если наибольший элемент не является текущим, то меняем их местами и вызывает heapify для поддерева
        if (greatest != i) {
            int tmp = array[i];
            array[i] = array[greatest];
            array[greatest] = tmp;

            heapify(array, length, greatest);
        }
    }
}
