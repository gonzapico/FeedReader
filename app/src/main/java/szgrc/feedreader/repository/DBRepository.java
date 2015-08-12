package szgrc.feedreader.repository;

import java.util.List;

import javax.inject.Singleton;

import szgrc.feedreader.domain.feed.Feed;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
@Singleton
public class DBRepository implements FeedRepository {

    @Override
    public List<Feed> obtainContacts() {
        return null;
    }

    @Override
    public Feed obtain(String id) {
        return null;
    }
}
