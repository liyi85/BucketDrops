package com.example.andrearodriguez.bucketdrops;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by andrearodriguez on 6/22/16.
 */
public class AppBucketDrops extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration configuration=new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(configuration);
    }
}
