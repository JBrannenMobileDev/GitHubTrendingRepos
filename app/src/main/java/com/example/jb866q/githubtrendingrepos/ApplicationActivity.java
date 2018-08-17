package com.example.jb866q.githubtrendingrepos;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jb866q.githubtrendingrepos.utils.RealmUISingleton;

import io.realm.Realm;

public class ApplicationActivity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
        RealmUISingleton.getInstance().initRealmInstance();
    }
}
