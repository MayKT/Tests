package com.mkttestprojects.myapplication.di.main;

import androidx.lifecycle.ViewModel;

import com.mkttestprojects.myapplication.di.ViewModelKey;
import com.mkttestprojects.myapplication.ui.main.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    public abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);

}
