package com.example.sort;

import java.util.Comparator;

public class ShakerSort<T> implements SortInterface<T> {


    public ShakerSort() {
    }

    @Override
    public void sort(T[] array, Comparator<T> comparator , int len ) {
        int left = 0 ;
        int rigth = len - 1;
        while(left <= rigth)
        {
            for (int i = left ; i < rigth ; i++) {
                if (comparator.compare(array[i], array[i + 1]) > 0) {
                    T temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
            rigth--;
            for (int i = rigth ; i > left ; i--) {
                if (comparator.compare(array[i - 1] , array[i]) < 0) {
                    T temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                }
            }
            left++;
        }


    }
}
