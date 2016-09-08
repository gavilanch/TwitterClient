package com.example.felipe.twitterclient.hasthtags;

/**
 * Created by Felipe on 08-Sep-16.
 */
public class HashtagsInteractorImpl implements HashtagsInteractor {
    private HashtagsRepository hashtagsRepository;

    public HashtagsInteractorImpl(HashtagsRepository hashtagsRepository) {
        this.hashtagsRepository = hashtagsRepository;
    }

    @Override
    public void getHashtagItemsList() {
        hashtagsRepository.getHashtags();
    }
}
