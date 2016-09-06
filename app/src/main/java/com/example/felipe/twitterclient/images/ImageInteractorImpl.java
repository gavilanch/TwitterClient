package com.example.felipe.twitterclient.images;

/**
 * Created by Felipe on 06-Sep-16.
 */
public class ImageInteractorImpl implements ImagesInteractor {

    private ImagesRepository repository;

    public ImageInteractorImpl(ImagesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getImages();
    }
}
