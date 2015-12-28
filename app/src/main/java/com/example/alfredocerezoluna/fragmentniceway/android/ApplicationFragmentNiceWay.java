package com.example.alfredocerezoluna.fragmentniceway.android;

import android.app.Application;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by jachu on 28/12/15.
 */
public class ApplicationFragmentNiceWay extends Application {

    public static Bus mBus = new Bus(ThreadEnforcer.MAIN);

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public Bus getBusInstance(){
        return mBus;
    }

}
