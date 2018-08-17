package com.example.jb866q.githubtrendingrepos.utils;

import io.realm.Realm;

/**
 * Created by jb866q on 8/16/18.
 */

public class RealmUISingleton {
    private static final RealmUISingleton ourInstance = new RealmUISingleton();

    public static RealmUISingleton getInstance() {
        return ourInstance;
    }

    private Realm realm;

    private RealmUISingleton() {
    }

    public void initRealmInstance(){
        realm = Realm.getDefaultInstance();
    }

    public Realm getRealmInstance(){
        return realm;
    }

    public void closeRealmInstance(){
        if(!realm.isClosed()) realm.close();
    }
}
