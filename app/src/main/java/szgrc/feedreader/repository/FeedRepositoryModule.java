package szgrc.feedreader.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import szgrc.feedreader.di.ApiModule;
import szgrc.feedreader.di.DBModule;
import szgrc.feedreader.repository.datasources.FeedAPIDataSource;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
@Module(
        includes = {
                ApiModule.class, DBModule.class
        },
        complete = false,
        library = true)
public class FeedRepositoryModule {

    @Provides @Singleton FeedRepository provideFeedRepository(
            FeedAPIDataSource networkDataSource) {
        return new FeedRepositoryImpl(networkDataSource);
    }
}
