package com.example.felipe.twitterclient.hasthtags.di;

import com.example.felipe.twitterclient.TwitterClientApp;
import com.example.felipe.twitterclient.hasthtags.HashtagsFragment;
import com.example.felipe.twitterclient.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Felipe on 08-Sep-16.
 */
@Singleton
@Component(modules = {HashtagsModule.class, LibsModule.class})
public interface HashtagsComponent {
    void inject(HashtagsFragment fragment);
}
