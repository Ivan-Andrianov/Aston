
package org.exercises;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class QuickSorterTest {

    public List<Integer> list;
    public List<Integer> emptyList;

    @BeforeAll
    void setUp() {
        list = new MyArrayList<>();
        list.add(10);
        list.add(2);
        list.add(7);
        list.add(4);
        list.add(200);
        list.add(-11);
        list.add(6);
        list.add(-33);

        emptyList = new MyArrayList<>();
    }

    @Test
    void sort() {
        list.sort();
        assertThat(list.size()).isEqualTo(8);
        assertThat(list.get(0)).isEqualTo(-33);
        assertThat(list.get(7)).isEqualTo(200);
        assertThat(list.get(2)).isEqualTo(2);
        assertThat(list.get(3)).isEqualTo(4);
    }

    @Test
    void sortEmptyList() {
        emptyList.sort();
        assertThat(emptyList.size()).isEqualTo(0);
    }
}