package com.example;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public interface Repository<T> {

    void init();
    void insert(T t) throws NoSuchFieldException, IllegalAccessException;
    List<T> getAll();
    void update(T t , String name);
    void delete(String name);

    default T getNewInstance() {
        try {
            return (T) getType().getDeclaredConstructor().newInstance();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }

    default Class<?> getType() {
        return ((Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    default String getTableName(){

        String[] tal = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName().split("\\.");
        return tal[tal.length-1].toLowerCase();
    }

    default Field[] getFields() {
        return ((Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getDeclaredFields();
    }
}

