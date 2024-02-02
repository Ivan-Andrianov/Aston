package org.exercises;

import java.util.*;

public class MyArrayList<T extends Comparable<T>> implements List<T>{

    private Object[] array;  //Массив, хранящий элементы списка
    private static final int DEFAULT_CAPACITY = 20; //Первоначальная вместимость this.array
    private int size;  //Размер списка


    public MyArrayList(){
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int capacity){
        if (capacity>0) {
            array = new Object[capacity];
        }else if (capacity == 0){
            array = new Object[DEFAULT_CAPACITY];
        }else{
            throw new IllegalArgumentException("Вместимость не может быть меньше нуля");
        }
    }

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
    public void remove(T element) {
        for (int i=0;i<size;i++){
            if (element.equals(array[i])){
                System.arraycopy(array,i+1,array,i,size-i);
                array[size--] = null;
                return;
            }
        }
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

        for (int i=0;i<size;i++){
            if (element.equals(array[i])){
                isContained = true;
            }
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

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return array[index]!=null;
            }

            @Override
            public T next() {
                return (T) array[index++];
            }
        };
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


