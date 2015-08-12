package szgrc.feedreader.di;

import android.app.Application;
import android.view.LayoutInflater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import szgrc.feedreader.FeedReaderApplication;
import szgrc.feedreader.domain.FeedsModule;
import szgrc.feedreader.executor.ExecutorModule;

/**
 * Dagger module with application scope.
 *
 * Created by gonzalofernandez on 11/08/15.
 */
@Module(
        includes = {
                ExecutorModule.class, FeedsModule.class
        },
        injects = {
                FeedReaderApplication.class
        }, library = true)
public final class AppModule {

    private final Application context;

    public AppModule(Application context) {
        this.context = context;
    }

    @Provides
    LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(context);
    }

    @Provides @Singleton
    Application provideApplicationContext() {
        return this.context;
    }
}
