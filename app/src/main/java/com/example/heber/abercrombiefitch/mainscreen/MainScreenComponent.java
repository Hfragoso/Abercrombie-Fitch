package com.example.heber.abercrombiefitch.mainscreen;

import com.example.heber.abercrombiefitch.data.component.NetComponent;
import com.example.heber.abercrombiefitch.mainscreen.MainScreenModule;
import com.example.heber.abercrombiefitch.mainscreen.MainActivity;
import com.example.heber.abercrombiefitch.util.CustomScope;

import dagger.Component;

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity activity);
}