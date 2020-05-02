package com.mkttestprojects.myapplication.di;

import com.mkttestprojects.myapplication.ui.main.MainActivity;
import com.mkttestprojects.myapplication.di.main.MainScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract  class ActivityBuildersModule {

    @MainScope
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

}
