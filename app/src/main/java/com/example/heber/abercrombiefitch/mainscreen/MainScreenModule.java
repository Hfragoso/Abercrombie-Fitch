package com.example.heber.abercrombiefitch.mainscreen;

import com.example.heber.abercrombiefitch.mainscreen.MainScreenContract;
import com.example.heber.abercrombiefitch.util.CustomScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainScreenModule {
    private final MainScreenContract.View mView;


    public MainScreenModule(MainScreenContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    MainScreenContract.View providesMainScreenContractView() {
        return mView;
    }
}