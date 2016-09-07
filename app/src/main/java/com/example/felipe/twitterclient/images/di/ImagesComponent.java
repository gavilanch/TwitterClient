package com.example.felipe.twitterclient.images.di;

import com.example.felipe.twitterclient.images.ImagesPresenter;
import com.example.felipe.twitterclient.images.ui.ImagesFragment;
import com.example.felipe.twitterclient.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by Felipe on 06-Sep-16.
 */
@Singleton @Component(modules = {LibsModule.class, ImagesModule.class})
public interface ImagesComponent {
    void inject(ImagesFragment fragment);
    ImagesPresenter getPresenter();

}
