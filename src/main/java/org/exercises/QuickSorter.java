package org.exercises;


/**
 * Реализация интерфейса Sorter. Представляет алгоритм быстрой сортировки.
 * @param <T> тип сортируемого элемента
 */
public class QuickSorter<T extends Comparable<T>> implements Sorter<T>{

    public QuickSorter(){}

    public void sort(List<T> list, int left, int right) {
        if (left < right) {
            int base = partition(list, left, right);

            sort(list, left, base - 1);
            sort(list, base + 1, right);
        }
    }

    /**
     * Поиск опорного элемента списка.
     * @param list сортируемый список
     * @param left индекс начала области сортировки списка
     * @param right индекс конца области сортировки списка
     * @return индекс опорного элемента
     */
    private int partition(List<T> list, int left, int right) {
        T pivot = list.get(right);
        int i = (left - 1);
        for (int j = left; j < right; j++) {
            if (list.get(j).compareTo(pivot)<0) {
                i++;
                T temp = list.get(i);
                list.set(list.get(j),i);
                list.set(temp,j);
            }
        }


        T temp = list.get(i+1);
        list.set(list.get(right),i+1);
        list.set(temp,right);


        return i + 1;
    }
}
