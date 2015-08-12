package szgrc.feedreader.repository;

import java.util.List;

import szgrc.feedreader.domain.feed.Feed;
import szgrc.feedreader.repository.datasources.FeedAPIDataSource;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
public class FeedRepositoryImpl implements FeedRepository {

    private final FeedAPIDataSource networkDataSource;
//    private final FeedBDDataSource bddDataSource;

    public FeedRepositoryImpl(FeedAPIDataSource networkDataSource) {
        this.networkDataSource = networkDataSource;
//        this.bddDataSource = bddDataSource;
    }

    @Override public List<Feed> obtainContacts() {
        List<Feed> contacts = null;
        try {
            contacts = this.networkDataSource.obtainContacts();
        } catch (Exception cacheException) {
        }
        return contacts;
    }


    @Override public Feed obtain(String id) {
        try {
//            return bddDataSource.obtain(id);
        } catch (Exception e) {
        }
        return null;
    }
}
