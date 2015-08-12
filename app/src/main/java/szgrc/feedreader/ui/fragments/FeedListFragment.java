package szgrc.feedreader.ui.fragments;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.carlosdelachica.easyrecycleradapters.recycler_view_manager.EasyRecyclerViewManager;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.Bind;
import szgrc.feedreader.R;
import szgrc.feedreader.domain.feed.Feed;
import szgrc.feedreader.domain.feed.FeedCollection;
import szgrc.feedreader.ui.presenter.FeedsListPresenter;
import szgrc.feedreader.ui.views.FeedListView;
import szgrc.feedreader.utils.UIUtils;

/**
 * Created by gonzalofernandez on 11/08/15.
 */
public class FeedListFragment extends BaseFragment implements FeedListView, SwipeRefreshLayout.OnRefreshListener {

    private static final String EXTRA_FEEDS = "extra_feeds_list";

    @Inject
    FeedsListPresenter feedsListPresenter;

    private boolean useSaveInstanceState = true;

    @Bind(R.id.pbLoading)
    ProgressBar pbLoading;

    @Bind(R.id.lvFeeds)
    ListView lvFeeds;

    @Bind(R.id.swipeRefreshFeeds)
    SwipeRefreshLayout srlRefreshFeeds;

    private EasyRecyclerViewManager recyclerViewManager;

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeListView();
        feedsListPresenter.setView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        feedsListPresenter.resume();
    }

    public void disableSaveInstanceState() {
        useSaveInstanceState = false;
    }

    private void initializeListView() {
        // Setting the adapter to the list view
    }


    @Override public void showLoading() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override public boolean isReady() {
        return isAdded();
    }

    @Override public boolean isAlreadyLoaded() {
//        return adapter.getCount() > 0;
        return true;
    }

    @Override public void hideLoading() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override public void feedsListsNotFoundMessage() {
        UIUtils.showShortSnackbar(getActivity().getWindow().getDecorView(), getString(R.string.not_found_message));
    }

    @Override public void feedsListsErrorMessage() {
        UIUtils.showShortSnackbar(getActivity().getWindow().getDecorView(), getString(R.string.error_message));
    }

    @Override
    public void setFeeds(Collection<Feed> tvShows) {

    }

    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (useSaveInstanceState) {
            outState.putSerializable(EXTRA_FEEDS, feedsListPresenter.getCurrentFeeds());
        }
    }

    @Override public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            final FeedCollection feeds = (FeedCollection) savedInstanceState.getSerializable(EXTRA_FEEDS);
            updatePresenterWithSavedTvShow(feeds);
        }
    }

    private void updatePresenterWithSavedTvShow(final FeedCollection feedCollection) {
    }

    @Override protected int getFragmentLayout() {
        return R.layout.fragment_feeds_list;
    }

    @Override
    public void onRefresh() {

    }
}
