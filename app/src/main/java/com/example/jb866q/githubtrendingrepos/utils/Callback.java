package com.example.jb866q.githubtrendingrepos.utils;

/**
 * Created by jb866q on 8/16/18.
 */

public interface Callback<T> {
    void onResponse(T object);
    void onFailure(Exception e);
}