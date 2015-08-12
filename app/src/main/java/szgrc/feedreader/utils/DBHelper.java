package szgrc.feedreader.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import szgrc.feedreader.domain.feed.Feed;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
public class DBHelper extends OrmLiteSqliteOpenHelper {

    private static final String TAG = DBHelper.class.getSimpleName();
    private static final int DATABASE_VERSION = 1;

    public DBHelper(String databaseName, final Context context) {
        super(context, databaseName, null, DATABASE_VERSION);
    }

    @Override public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Feed.class);
        } catch (SQLException e) {
            Log.e(TAG, "Unable to create tables", e);
        }
    }

    @Override public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource,
                                    int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Feed.class, true);
        } catch (SQLException e) {
            Log.e(TAG, "Unable to drop tables", e);
        }
    }

    public Dao<Feed, Integer> getFeedDao() {
        try {
            return getDao(Feed.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
