package szgrc.feedreader.ui.activities;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import szgrc.feedreader.di.AppModule;
import szgrc.feedreader.domain.GetFeedsListInteractor;
import szgrc.feedreader.executor.Bus;
import szgrc.feedreader.ui.fragments.FeedListFragment;
import szgrc.feedreader.ui.presenter.FeedsListPresenter;
import szgrc.feedreader.ui.views.FeedListView;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
@Module(
        addsTo = AppModule.class,
        injects = {FeedsListActivity.class, FeedListFragment.class}, library = true)
public class FeedListModule {

    private FeedListView mainView;

    public FeedListModule(FeedListView mainView) {
        this.mainView = mainView;
    }

    @Provides
    @Singleton
    FeedsListPresenter provideFeedListPresenter(Bus bus, GetFeedsListInteractor getFeedsListInteractor) {
        return new FeedsListPresenter(bus, getFeedsListInteractor);
    }
}
