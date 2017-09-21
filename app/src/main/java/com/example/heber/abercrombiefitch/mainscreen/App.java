package com.example.heber.abercrombiefitch.mainscreen;

import android.app.Application;

import com.example.heber.abercrombiefitch.data.component.DaggerNetComponent;
import com.example.heber.abercrombiefitch.data.component.NetComponent;
import com.example.heber.abercrombiefitch.data.module.AppModule;
import com.example.heber.abercrombiefitch.data.module.NetModule;

public class App extends Application {
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}