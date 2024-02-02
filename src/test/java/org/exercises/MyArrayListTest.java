package org.exercises;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class MyArrayListTest {

    public List<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @org.junit.jupiter.api.Test
    void add() {
        assertThat(list.size()).isEqualTo(3);
        list.add(4);
        assertThat(list.size()).isEqualTo(4);
        list.add(5);
        list.add(6);
        assertThat(list.size()).isEqualTo(6);
    }

    @org.junit.jupiter.api.Test
    void insertInMiddle() {
        list.insert(10,1);
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(1)).isEqualTo(10);
    }

    @Test
    void insertAtEnd(){
        list.insert(10,0);
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(0)).isEqualTo(10);

        list.insert(20,-20);
        assertThat(list.size()).isEqualTo(5);
        assertThat(list.get(0)).isEqualTo(20);
    }

    @Test
    void insertAtBeginning(){
        list.insert(10,3);
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(3)).isEqualTo(10);

        list.insert(20,20);
        assertThat(list.size()).isEqualTo(5);
        assertThat(list.get(4)).isEqualTo(20);
    }

    @org.junit.jupiter.api.Test
    void remove() {
        list.remove(1);
        assertThat(list.size()).isEqualTo(2);
    }

    @org.junit.jupiter.api.Test
    void get() {
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(2)).isEqualTo(3);
    }

    @Test
    void getByWrongIndex(){
        try {
            list.get(-1);
            fail("Список не может выдавать значение по отрицательному индексу");
        }catch (IndexOutOfBoundsException e){}

        try{
            list.get(20);
            fail("Список не может выдавать значение по индексу, который больше размера списка");
        }catch (IndexOutOfBoundsException e){}
    }

    @org.junit.jupiter.api.Test
    void clear() {
        list.clear();
        assertThat(list.size()).isEqualTo(0);
    }
}