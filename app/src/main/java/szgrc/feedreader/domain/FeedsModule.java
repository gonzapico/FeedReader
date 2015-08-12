package szgrc.feedreader.domain;

import android.os.Build;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import szgrc.feedreader.BuildConfig;
import szgrc.feedreader.data.RetrofitLog;
import szgrc.feedreader.data.UserAgent;
import szgrc.feedreader.domain.feed.FeedCollection;
import szgrc.feedreader.executor.Bus;
import szgrc.feedreader.executor.BusImpl;
import szgrc.feedreader.executor.InteractorModule;
import szgrc.feedreader.repository.FeedRepositoryModule;
import szgrc.feedreader.utils.GlobalConfig;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
@Module(includes = {InteractorModule.class, FeedRepositoryModule.class}, library = true, complete = false)
public final class FeedsModule {

    @Provides @Singleton
    Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(GlobalConfig.API_URL);
    }

    @Provides @Singleton @RetrofitLog
    boolean provideRetrofitLog() {
        return GlobalConfig.RETROFIT_LOG;
    }

    @Provides @Singleton @UserAgent
    String provideUserAgent() {
        return String.format("Sample-Android;%s;%s;%s;%d;", Build.MANUFACTURER, Build.MODEL,
                Build.VERSION.RELEASE, BuildConfig.VERSION_CODE);
    }

    @Provides @Singleton
    FeedCollection provideCatalog() {
        return new FeedCollection();
    }

    @Provides @Singleton
    Bus provideEventbus() {
        return new BusImpl();
    }
}

