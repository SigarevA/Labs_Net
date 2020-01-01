package com.example.sort;

import java.util.Comparator;

public interface SortInterface <T> {
    void sort (T[] array, Comparator<T> check, int len);
}
