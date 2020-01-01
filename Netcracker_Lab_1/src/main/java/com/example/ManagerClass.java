package com.example;

import com.example.repository.ControlPersons;
import com.example.sort.SortInterface;
import com.example.sort.Sorted;

import java.lang.reflect.Field;

import static java.lang.System.out;

public class ManagerClass <T> {


    public ManagerClass(){

    }
    public void addInterface ( T object ) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c =  object.getClass();
        Field[] fields = c.getDeclaredFields();
        addFillField(fields, object);
    }

    public T createReposetory() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c = Class.forName("com.example.repository.ControlPersons");
        T o = (T) c.newInstance();
        Field[] fields = c.getDeclaredFields();
        addFillField(fields, o);
        return o;
    }


    private void addFillField (Field[] fields, T object ) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        for (Field field : fields) {
            Sorted annotation = field.getAnnotation(Sorted.class);
            if (annotation != null) {
                field.setAccessible(true);
                String name = "com.example.sort." + annotation.value();
                Class cs = Class.forName(name);
                SortInterface sortInterface = (SortInterface) cs.newInstance();
                field.set(object, sortInterface);
            }
        }
    }

}
