package org.exercises;

public interface List<T> extends Iterable{
    /*
       Добавление элемента в конец списка
       @Params
            element - элемент добавляемый в конец списка.
     */
    void add(T element);

    /*
        Вставка элемента в заданную позицию
        @Params
            element - элемент вставляемый в заданную позицию;
            index - индекс позиции.
     */
    void insert(T element,int index);

    /*
        Удаление первого вхождения элемента
        @Params
            element - удаляемый элемент.
     */
    void remove(T element);

    /*
        Получение элемента по индексу
        @Params
            index - индекс получаемого элемента.
     */
    T get(int index);

    /*
       Очищение всего списка
    */
    void clear();

    /*
        Задает значение элементу по заданному индексу.
        @Params
            value - задаваемое значение;
            index - индекс элемента.
     */
    void set(T value,int index);

    /*
        Сортировка списка.
     */
    void sort();

    /*
        Проверка списка на пустоту.
    */
    boolean isEmpty();

    /*
        Проверка на содержание элемента
        @Params
            element - проверяемый на наличие в списке элемент.
     */
    boolean contains(T element);

    /*
        Получение длины списка.
     */
    int size();

    /*
        Увеличение (при необходимости) массива, хранящего все элементы.
     */
    void ensureCapacity();


    /*
        Получение списка, преобразованного в массив.
     */
    Object[] toArray();
}
