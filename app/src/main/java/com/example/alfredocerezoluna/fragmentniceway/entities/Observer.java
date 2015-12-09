package com.example.alfredocerezoluna.fragmentniceway.entities;

/**
 * Created by alfredocerezoluna on 9/12/15.
 */
public interface Observer<T> {

    void onFinished(T result);
    void onerror(Exception exception);
}
