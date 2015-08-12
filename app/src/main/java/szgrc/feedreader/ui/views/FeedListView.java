package szgrc.feedreader.ui.views;

import java.util.Collection;

import szgrc.feedreader.domain.feed.Feed;

/**
 * Created by gonzalofernandez on 11/08/15.
 */
public interface FeedListView {

    void hideLoading();

    void showLoading();

    void setFeeds(final Collection<Feed> tvShows);

    boolean isReady();

    boolean isAlreadyLoaded();

    void feedsListsNotFoundMessage();

    void feedsListsErrorMessage();

}
