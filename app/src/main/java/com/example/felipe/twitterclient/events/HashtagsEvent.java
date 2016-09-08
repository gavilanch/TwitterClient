package com.example.felipe.twitterclient.events;

import com.example.felipe.twitterclient.entities.Hashtag;

import java.util.List;

/**
 * Created by Felipe on 08-Sep-16.
 */
public class HashtagsEvent {
    private String error;
    private List<Hashtag> hashtags;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
}
