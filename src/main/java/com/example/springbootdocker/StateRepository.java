package com.example.springbootdocker;

import java.util.List;

public interface StateRepository {
    List<State> findAll();
}
