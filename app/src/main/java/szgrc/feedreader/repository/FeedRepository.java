package szgrc.feedreader.repository;

import java.util.List;

import szgrc.feedreader.domain.feed.Feed;

/**
 * Created by gonzalofernandez on 11/08/15.
 */
public interface FeedRepository {

    List<Feed> obtainContacts();

    Feed obtain(String id);
}
