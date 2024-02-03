package org.exercises;

import java.util.*;

public class MyArrayList<T extends Comparable<T>> implements List<T>{

    private Object[] array;  //Массив, хранящий элементы списка
    private static final int DEFAULT_CAPACITY = 20; //Первоначальная вместимость this.array
    private int size;  //Размер списка
    private volatile int modificationCount; //Количество структурных изменений списка

    /**
     * Конструктор класса без параметров для создания списка
     * с параметрами по умолчанию. Вместимость массива будет
     * равна дефолтному значению, указанному в переменной
     * DEFAULT_CAPACITY. Изначальное количество элементов
     * списка равно 0.
     */
    public MyArrayList(){
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Конструктор класса с параметром для настройки вместимости.
     * @param capacity размер массива элементов списка
     */
    public MyArrayList(int capacity){
        if (capacity>0) {
            array = new Object[capacity];
        }else if (capacity == 0){
            array = new Object[DEFAULT_CAPACITY];
        }else{
            throw new IllegalArgumentException("Вместимость не может быть меньше нуля");
        }
    }

    /**
     * Конструктор класса создающий объект списка на основе
     * элементов предоставленных параметром collection.
     * @param collection список элементов вставляемых в новый список
     */
    public MyArrayList(List<T> collection){
        array = new Object[collection.size()];
        size = 0;
        for (Object element:collection){
            array[size++] = element;
        }
    }

    @Override
    public void add(T element) {
        ensureCapacity();
        array[size] = element;
        size++;
    }

    @Override
    public void insert(T element, int index) {
        ensureCapacity();
        if (index<0) index=0;
        if (index>=size) index = size;
        System.arraycopy(array,index+1,array,index,size-index);
        array[index] = element;
        size++;
    }

    @Override
    public boolean remove(Object element) {
        for (int i=0;i<size;i++){
            if (element.equals(array[i])){
                System.arraycopy(array,i+1,array,i,size-i);
                array[size--] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public void set(T value, int index) {
        if (index<0 || index>size) throw new IllegalArgumentException();
        array[index] = value;
    }

    @Override
    public T get(int index) {
        if (index<0 || index>=size) throw new IndexOutOfBoundsException();
        return (T) array[index];
    }

    @Override
    public void clear() {
        if (size!=0){
            array = new Object[DEFAULT_CAPACITY];
            size = 0;
        }
    }

    @Override
    public boolean isEmpty() {
        return size==0?true:false;
    }

    @Override
    public boolean contains(T element) {
        boolean isContained = false;

        for (T listElement: this){
            if (listElement.equals(element)) isContained = true;
        }

        return isContained;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void ensureCapacity() {
        if (size > array.length*0.75){
            Object[] newArray = new Object[array.length*2];
            System.arraycopy(array,0,newArray,0,array.length);
            array = newArray;
        }
    }


    /**
     * Fail-fast итератор
     * @param <T> тип элемента итерируемого списка
     */
    private class MyArrayItr<T> implements Iterator<T>{
        int position;
        int expectedModificationCount;
        int lastRet;

        MyArrayItr(){
            position = 0;
            expectedModificationCount = modificationCount;
            lastRet = -1;
        }
        @Override
        public boolean hasNext() {
            return position!=size;
        }

        @Override
        public T next() {
            checkForModificationCount();
            if (position>=size) throw new NoSuchElementException();
            Object[] elements = array;
            if (expectedModificationCount!=elements.length) throw new ConcurrentModificationException();
            lastRet = position;
            return (T) elements[position++];
        }

        @Override
        public void remove() {
            if (lastRet<0) throw new IllegalStateException();
            checkForModificationCount();

            try {
                MyArrayList.this.remove(array[lastRet]);
                position = lastRet;
                lastRet = -1;
                expectedModificationCount = modificationCount;
            }catch (IndexOutOfBoundsException e){
                throw new ConcurrentModificationException();
            }
        }

        public void checkForModificationCount(){
            if (modificationCount!=expectedModificationCount) throw new ConcurrentModificationException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayItr<>();
    }

    @Override
    public Object[] toArray(){
        return array;
    }

    @Override
    public void sort(){
        Sorter sorter = new QuickSorter();
        sorter.sort(this,0,size-1);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        for (Object value:array){
            buffer.append(value+", ");
        }
        buffer.append("]");

        return buffer.toString();
    }
}


