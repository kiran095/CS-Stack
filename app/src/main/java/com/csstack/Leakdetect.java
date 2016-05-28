package com.csstack;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by nandhu on 24/5/16.
 */
public class Leakdetect extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
