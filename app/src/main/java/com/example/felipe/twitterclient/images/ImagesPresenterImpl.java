package com.example.felipe.twitterclient.images;



import com.example.felipe.twitterclient.images.events.ImagesEvent;
import com.example.felipe.twitterclient.images.ui.ImagesView;
import com.example.felipe.twitterclient.lib.base.EventBus;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Felipe on 06-Sep-16.
 */
public class ImagesPresenterImpl implements ImagesPresenter {

    private EventBus eventBus;
    private ImagesView view;
    private ImagesInteractor interactor;

    public ImagesPresenterImpl(ImagesView view, EventBus eventBus, ImagesInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onResume() {
        eventBus.register(this);
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void getImageTweets() {
        if (view != null){
            view.hideImages();
            view.showProgressBar();
        }
        interactor.execute();
    }

    @Override
    @Subscribe
    public void onEventMainThread(ImagesEvent event) {
        String errorMessage = event.getError();
        if (view != null){
            view.showImages();
            view.hideProgressBar();

            if (errorMessage != null){
                view.onError(errorMessage);
            } else{
                view.setContent(event.getImages());
            }

        }
    }
}
