package com.example.sort;

import java.util.Comparator;

public class BubbleSort<T> implements SortInterface<T> {

    public BubbleSort() {
    }

    @Override
    public void sort(T[] array , Comparator<T> comparator, int len) {
        for (int i = 0 ; i  < array.length ; i++ ){
            for (int j = i + 1; j < len ; j++ )
            {
                if( comparator.compare(array[j] , array[i]) > 0 ){
                    T temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
}
