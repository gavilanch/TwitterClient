package com.example.felipe.twitterclient.images.di;

import com.example.felipe.twitterclient.api.CustomTwitterApiClient;
import com.example.felipe.twitterclient.entities.Image;
import com.example.felipe.twitterclient.images.ImageInteractorImpl;
import com.example.felipe.twitterclient.images.ImagesInteractor;
import com.example.felipe.twitterclient.images.ImagesPresenter;
import com.example.felipe.twitterclient.images.ImagesPresenterImpl;
import com.example.felipe.twitterclient.images.ImagesRepository;
import com.example.felipe.twitterclient.images.ui.ImagesRepositoryImpl;
import com.example.felipe.twitterclient.images.ui.ImagesView;
import com.example.felipe.twitterclient.images.ui.adapters.ImagesAdapter;
import com.example.felipe.twitterclient.images.ui.adapters.OnItemClickListener;
import com.example.felipe.twitterclient.lib.base.EventBus;
import com.example.felipe.twitterclient.lib.base.ImageLoader;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Felipe on 06-Sep-16.
 */
@Module
public class ImagesModule {
    private ImagesView view;
    private OnItemClickListener clickListener;

    public ImagesModule(ImagesView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    ImagesAdapter providesAdapter(List<Image> dateset, ImageLoader imageLoader, OnItemClickListener clickListener){
        return new ImagesAdapter(dateset, imageLoader, clickListener);
    }


    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Image> providesList(){
        return new ArrayList<Image>();
    }

    @Singleton
    @Provides
    ImagesPresenter providesImagesPresenter(ImagesView view, EventBus eventBus, ImagesInteractor interactor){
        return new ImagesPresenterImpl(view, eventBus, interactor);
    }

    @Singleton
    @Provides
    ImagesView providesImagesView(){
        return this.view;
    }

    @Singleton
    @Provides
    ImagesInteractor providesImagesInteractor(ImagesRepository repository){
        return new ImageInteractorImpl(repository);
    }

    @Singleton
    @Provides
    ImagesRepository providesImagesInteractor(EventBus eventBus, CustomTwitterApiClient client){
        return new ImagesRepositoryImpl(eventBus, client);
    }

    @Singleton
    @Provides
    CustomTwitterApiClient providesCustomTwitterApiClient(Session session){
        return new CustomTwitterApiClient(session);
    }


    @Singleton
    @Provides
    Session providesTwitterSession(){
        return Twitter.getSessionManager().getActiveSession();
    }

}
