package com.example.felipe.twitterclient.images;

import com.example.felipe.twitterclient.entities.Image;

import java.util.List;

/**
 * Created by Felipe on 04-Sep-16.
 */
public interface ImagesView {
    void showElements();
    void hideElements();
    void showProgressBar();
    void hideProgressBar();

    void onError(String error);
    void setContent(List<Image> items);
}
