package szgrc.feedreader.ui.presenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import szgrc.feedreader.di.ActivityModule;
import szgrc.feedreader.domain.GetFeedsListInteractor;
import szgrc.feedreader.executor.Bus;
import szgrc.feedreader.repository.FeedRepositoryModule;
import szgrc.feedreader.ui.activities.FeedsListActivity;
import szgrc.feedreader.ui.fragments.FeedListFragment;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
@Module(complete = false,
        addsTo = ActivityModule.class,
        injects = {
                FeedListFragment.class, FeedsListActivity.class, FeedRepositoryModule.class
        }) public final class FeedUIModule {

        @Provides
        @Singleton
        FeedsListPresenter provideMainPresenter(Bus bus, GetFeedsListInteractor getFeedsListInteractor) {
                return new FeedsListPresenter(bus, getFeedsListInteractor);
        }
}
