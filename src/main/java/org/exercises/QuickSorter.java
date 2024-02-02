package org.exercises;

import java.util.Arrays;


/*
    Реализация интерфейса Sorter. Представляет алгоритм быстрой сортировки.
    @TypeParams
        T - тип элемента сортируемого списка.
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

    /*
        Поиск опорного элемента списка.
        @Params
            list - сортируемый список;
            left - индекс начала области сортировки списка;
            right - индекс конца области сортировки списка;
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
