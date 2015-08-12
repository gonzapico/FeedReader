package szgrc.feedreader.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import szgrc.feedreader.data.DatabaseName;
import szgrc.feedreader.utils.DBHelper;
import szgrc.feedreader.utils.GlobalConfig;

/**
 * Dagger module with the scope of the DB.
 *
 * Created by gonzalofernandez on 12/08/15.
 */
@Module(
        complete = false,
        library = true)
public class DBModule {

    @Provides
    @Singleton
    public DBHelper provideDatabaseHelper(
            @DatabaseName String databaseName, Application app) {
        return new DBHelper(databaseName, app);
    }

    @Provides
    @Singleton
    @DatabaseName
    String provideDatabaseName() {
        return "intelygenz" + (GlobalConfig.DEBUG ? "-dev" : "") + ".db";
    }
}
