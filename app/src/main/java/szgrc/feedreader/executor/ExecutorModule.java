package szgrc.feedreader.executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
@Module(library = true)
public final class ExecutorModule {

    @Provides
    @Singleton
    Executor provideExecutor(ThreadExecutor threadExecutor) {
        return threadExecutor;
    }

    @Provides @Singleton MainThread provideMainThread(MainThreadImpl mainThread) {
        return mainThread;
    }
}
