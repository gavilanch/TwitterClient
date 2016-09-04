package com.example.felipe.twitterclient.images;

import com.example.felipe.twitterclient.images.events.ImagesEvent;

/**
 * Created by Felipe on 04-Sep-16.
 */
public interface ImagesPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getImageTweets();
    void onEventMainThread(ImagesEvent event);
}
