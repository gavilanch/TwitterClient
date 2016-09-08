package com.example.felipe.twitterclient.hasthtags.ui;

import com.example.felipe.twitterclient.entities.Hashtag;

import java.util.List;

/**
 * Created by Felipe on 08-Sep-16.
 */
public interface HashtagView {
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void onHashtagsError(String error);
    void setHashtags(List<Hashtag> items);
}
