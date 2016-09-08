package com.example.felipe.twitterclient.hasthtags;

import com.example.felipe.twitterclient.events.HashtagsEvent;

/**
 * Created by Felipe on 08-Sep-16.
 */
public interface HashtagsPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getHashtagTweets();
    void onEventMainThread(HashtagsEvent event);
}
