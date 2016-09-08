package com.example.felipe.twitterclient.hasthtags.di;

import android.content.Context;

import com.example.felipe.twitterclient.api.CustomTwitterApiClient;
import com.example.felipe.twitterclient.entities.Hashtag;
import com.example.felipe.twitterclient.hasthtags.HashtagsInteractor;
import com.example.felipe.twitterclient.hasthtags.HashtagsInteractorImpl;
import com.example.felipe.twitterclient.hasthtags.HashtagsPresenter;
import com.example.felipe.twitterclient.hasthtags.HashtagsPresenterImpl;
import com.example.felipe.twitterclient.hasthtags.HashtagsRepository;
import com.example.felipe.twitterclient.hasthtags.HashtagsRepositoryImpl;
import com.example.felipe.twitterclient.hasthtags.adapters.HashtagsAdapter;
import com.example.felipe.twitterclient.hasthtags.ui.HashtagsView;
import com.example.felipe.twitterclient.hasthtags.ui.OnItemClickListener;
import com.example.felipe.twitterclient.lib.base.EventBus;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Felipe on 08-Sep-16.
 */
@Module
public class HashtagsModule {
    private HashtagsView view;
    private OnItemClickListener clickListener;

    public HashtagsModule(HashtagsView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    List<Hashtag> provideItems() {
        return new ArrayList<Hashtag>();
    }

    @Provides
    @Singleton
    OnItemClickListener provideClickListener() {
        return this.clickListener;
    }

    @Provides
    HashtagsAdapter provideAdapter(Context context, List<Hashtag> items, OnItemClickListener clickListener) {
        return new HashtagsAdapter(context, items, clickListener);
    }

    @Provides
    @Singleton
    HashtagsView provideHashtagsView() {
        return this.view;
    }

    @Provides
    @Singleton
    HashtagsPresenter provideHashtagsPresenter(HashtagsView view, HashtagsInteractor interactor, EventBus eventBus) {
        return new HashtagsPresenterImpl(view, interactor, eventBus);
    }

    @Provides
    @Singleton
    HashtagsInteractor provideHashtagsInteractor(HashtagsRepository repository) {
        return new HashtagsInteractorImpl(repository);
    }

    @Provides
    @Singleton
    HashtagsRepository provideHashtagsRepository(CustomTwitterApiClient client, EventBus eventBus) {
        return new HashtagsRepositoryImpl(client, eventBus);
    }

    @Provides
    @Singleton
    CustomTwitterApiClient provideTwitterApiClient(TwitterSession session) {
        return new CustomTwitterApiClient(session);
    }

    @Provides
    @Singleton
    TwitterSession provideTwitterSession() {
        return Twitter.getSessionManager().getActiveSession();
    }

}
