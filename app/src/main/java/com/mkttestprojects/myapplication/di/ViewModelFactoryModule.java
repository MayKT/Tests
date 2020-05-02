package com.mkttestprojects.myapplication.di;

import androidx.lifecycle.ViewModelProvider;
import com.mkttestprojects.myapplication.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract  class ViewModelFactoryModule  {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);

}
