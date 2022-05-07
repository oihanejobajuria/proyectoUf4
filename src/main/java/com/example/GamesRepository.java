package com.example;

public interface GamesRepository extends Repository<Games> {
    void populate();
    Integer getLastId();
}
