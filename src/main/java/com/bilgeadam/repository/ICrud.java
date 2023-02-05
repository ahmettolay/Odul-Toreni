package com.bilgeadam.repository;

import com.bilgeadam.entity.Film;

public interface ICrud <T> {

    void save(T t);

    void update(T t);
    void delete(int id);
}
