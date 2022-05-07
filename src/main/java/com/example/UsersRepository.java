package com.example;

public interface UsersRepository extends Repository<Users> {
    void populate();
    Integer getLastId();
}
