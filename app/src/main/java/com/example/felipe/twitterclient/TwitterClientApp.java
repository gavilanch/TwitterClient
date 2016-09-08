package com.example.felipe.twitterclient;

import android.app.Application;
import android.support.v4.app.Fragment;

import com.example.felipe.twitterclient.images.di.DaggerImagesComponent;
import com.example.felipe.twitterclient.images.di.ImagesComponent;
import com.example.felipe.twitterclient.images.di.ImagesModule;
import com.example.felipe.twitterclient.images.ui.ImagesView;
import com.example.felipe.twitterclient.images.ui.adapters.OnItemClickListener;
import com.example.felipe.twitterclient.lib.di.LibsModule;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

public class TwitterClientApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initFabric();
    }

    private void initFabric() {
        TwitterAuthConfig authConfig = new TwitterAuthConfig(BuildConfig.TWITTER_KEY, BuildConfig.TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
    }

    public ImagesComponent getImagesComponent(Fragment fragment, ImagesView view, OnItemClickListener clickListener){
        return DaggerImagesComponent.builder()
                .libsModule(new LibsModule(fragment))
                .imagesModule(new ImagesModule(view, clickListener))
                .build();
    }
}
