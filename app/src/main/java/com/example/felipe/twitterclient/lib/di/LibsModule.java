package com.example.felipe.twitterclient.lib.di;

import android.support.v4.app.Fragment;

import com.example.felipe.twitterclient.lib.GlideImageLoader;
import com.example.felipe.twitterclient.lib.GreenRobotEventBus;
import com.example.felipe.twitterclient.lib.base.EventBus;
import com.example.felipe.twitterclient.lib.base.ImageLoader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LibsModule {

    private Fragment fragment;

    public LibsModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @Singleton
    EventBus provideEventBus() {
        return new GreenRobotEventBus();
    }

    @Provides
    @Singleton
    ImageLoader provideImageLoader(Fragment fragment) {
        return new GlideImageLoader(fragment);
    }

    @Provides
    @Singleton
    Fragment provideImageLoaderFragment() {
        return this.fragment;
    }
}
