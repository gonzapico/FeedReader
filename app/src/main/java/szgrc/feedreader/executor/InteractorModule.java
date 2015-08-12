package szgrc.feedreader.executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import szgrc.feedreader.domain.GetFeedsListInteractor;
import szgrc.feedreader.repository.FeedRepository;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
@Module(
        complete = false,
        library = true
)
public class InteractorModule {

    @Provides
    @Singleton
    GetFeedsListInteractor provideGetListInteractor(Bus bus,
                                                       FeedRepository repository, Executor executor, MainThread mainThread) {
        return new GetFeedsListInteractor(bus, repository, executor, mainThread);
    }
}
