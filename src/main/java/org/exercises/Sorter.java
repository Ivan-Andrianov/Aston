package org.exercises;

/*
    Интерфейс, реализуемый классами, объекты которых сортируют список.

    Каждая реализация интерфейса Sorter может реализовывать определенные алгоритмы сортировки.
 */
public interface Sorter<T extends Comparable<T>> {

    /*
        Сортировка списка.
        @Params
            list - сортируемый список;
            left - индекс начала области сортировки списка;
            right - индекс конца области сортировки списка;
     */
    void sort(List<T> list, int left,int right);
}
