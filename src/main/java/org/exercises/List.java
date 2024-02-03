package org.exercises;

/**
 * API, предоставляющее методы для работы со списком элементов.
 * @param <T> тип элемента хранимого в списке.
 */
public interface List<T> extends Iterable<T>{
    /**
     * Добавление элемента в конец списка.
     * @param element элемент добавляемый в конец списка
     */
    void add(T element);

    /**
     * Вставка элемента в заданную параметром index позицию.
     * @param element вставляемый элемент;
     * @param index индекс позиции.
     */
    void insert(T element,int index);

    /**
     * Удаление первого вхождения элемента.
     *
     * @param element удаляемый элемент
     * @return
     */
    boolean remove(Object element);

    /**
     * Получение элемента по индексу.
     * @param index индекс получаемого значения
     * @return элемент расположенный по индексу
     */
    T get(int index);

    /**
     * Очищение всего списка
     */
    void clear();

    /**
     * Задает значение элементу по заданному индексу.
     * @param value задаваемое значение
     * @param index индекс элемента
     */
    void set(T value,int index);

    /**
     * Сортировка списка.
     */
    void sort();

    /**
     * Проверка списка на пустоту.
     * @return true, если список пустой, иначе false
     */
    boolean isEmpty();

    /**
     * Проверка на содержание элемента
     * @param element проверяемый на наличие элемент
     * @return true, если элемент есть, иначе false
     */
    /*

        @Params
            element - проверяемый на наличие в списке элемент.
     */
    boolean contains(T element);

    /**
     * Получение длины списка.
     * @return длина списка
     */
    int size();

    /**
     *  Увеличение (при необходимости) массива, хранящего все элементы.
     */
    void ensureCapacity();


    /**
     * Получение списка, преобразованного в массив.
     * @return массив элементов списка
     */
    Object[] toArray();
}
