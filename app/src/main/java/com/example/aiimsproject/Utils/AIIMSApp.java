package com.example.aiimsproject.Utils;

import android.app.Application;

    public class AIIMSApp extends Application {
    private static AIIMSApp mInstance;


    public void onCreate() {
        super.onCreate();
        mInstance = this;



    }

    public static AIIMSApp getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }
}
