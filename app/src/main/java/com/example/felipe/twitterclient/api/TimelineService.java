package com.example.felipe.twitterclient.api;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Felipe on 14-Jul-16.
 */
public interface TimelineService {

    @GET("/1.1/statuses/home_timeline.json")
    void homeTimeline(@Query("count") Integer count,
                      @Query("trim_user") Boolean trim_user,
                      @Query("exclude_replies") Boolean exclude_replies,
                      @Query("contributor_details") Boolean contributor_details,
                      @Query("include_entities") Boolean include_entities,
                      Callback<List<Tweet>> callback);

}
