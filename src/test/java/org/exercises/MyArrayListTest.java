package org.exercises;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

// все хорошо, есть только замечания по стилю
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
    void add() { // неинфорамативный нейминг методов, почитай конвенции наименования тестов
        assertThat(list.size()).isEqualTo(3); // все перемешано, чекни given when then
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
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1)); // вот так надо, без fail
        try{
            list.get(20);
            fail("Список не может выдавать значение по индексу, который больше размера списка"); // а зачем тут это?
        }catch (IndexOutOfBoundsException e){}
    }

    @org.junit.jupiter.api.Test
    void clear() {
        list.clear();
        assertThat(list.size()).isZero();
    }
}