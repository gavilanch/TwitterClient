package com.example.felipe.twitterclient.images.events;

import com.example.felipe.twitterclient.entities.Image;

import java.util.List;

/**
 * Created by Felipe on 04-Sep-16.
 */
public class ImagesEvent {

    private String error;
    private List<Image> images;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
