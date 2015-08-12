package szgrc.feedreader.ui.presenter;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Singleton;

import szgrc.feedreader.domain.GetFeedsEvent;
import szgrc.feedreader.domain.GetFeedsListInteractor;
import szgrc.feedreader.domain.feed.Feed;
import szgrc.feedreader.domain.feed.FeedCollection;
import szgrc.feedreader.executor.Bus;
import szgrc.feedreader.ui.views.FeedListView;

/**
 * Presenter in order to get the feeds thanks to interactor's implementation.
 *
 * Created by gonzalofernandez on 11/08/15.
 */
@Singleton
public class FeedsListPresenter extends BasePresenter {

    private Bus bus;
    private FeedListView view;
    private FeedCollection currentFeedsList;
    private final GetFeedsListInteractor getFeedsListInteractor;

    @Inject
    public FeedsListPresenter(Bus bus, GetFeedsListInteractor getFeedsListInteractor) {
        this.bus = bus;
        this.getFeedsListInteractor = getFeedsListInteractor;
    }

    public void setView(FeedListView view) {
        if (view == null) {
            throw new IllegalArgumentException("You can't set a null view");
        }
        this.view = view;
    }

    @Override
    public void init() {
        checkViewAlreadySetted();
    }

    @Override
    public void resume() {
        // when activity is on resume we are listening events from the bus
        bus.register(this);
        loadFeeds();
    }

    @Override
    public void pause() {
        // when activity has beeen paused we are NOT listening events from the bus
        bus.unregister(this);
    }

    public void loadFeeds(final FeedCollection feedCollection) {
        currentFeedsList = feedCollection;
        showFeeds(currentFeedsList.getFeeds());
    }

    public void onTvShowThumbnailClicked(final Feed feed) {
//        navigator.openTvShowDetails(tvShow);
    }

    public FeedCollection getCurrentFeeds() {
        return currentFeedsList;
    }

    /**
     * Use GetFeedList interactor to obtain a collection of feeds.
     * We hide progress bar when it finishes.
     */
    private void loadFeeds() {
        if (view.isReady()) {
            view.showLoading();
        }
        getFeedsListInteractor.execute();
    }

    private void notifyConnectionError() {
        if (view.isReady() && !view.isAlreadyLoaded()) {
            view.hideLoading();
            view.feedsListsErrorMessage();
        }
    }

    private void showFeeds(Collection<Feed> feeds) {
        if (view.isReady()) {
            view.setFeeds(feeds);
            view.hideLoading();
        }
    }

    private void checkViewAlreadySetted() {
        if (view == null) {
            throw new IllegalArgumentException("Remember to set a view for this presenter");
        }
    }

    public void onEvent(GetFeedsEvent event) {
        if (event.getError() == null) {
            view.setFeeds(event.getFeeds());
        } else {
        }
    }

    public void onRefresh() {
    }
}
