package szgrc.feedreader.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.ErrorHandler;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;
import szgrc.feedreader.data.RetrofitLog;
import szgrc.feedreader.data.UserAgent;
import szgrc.feedreader.repository.FeedRepositoryImpl;
import szgrc.feedreader.repository.datasources.FeedAPIDataSourceImpl;
import szgrc.feedreader.repository.datasources.FeedAPIService;

/**
 * Dagger module with the scope of the API.
 *
 * Created by gonzalofernandez on 12/08/15.
 */
@Module(
        complete = false,
        library = true
)
public class ApiModule {

    @Provides
    @Singleton
    FeedRepositoryImpl provideFeedAPIDataSource(
            FeedAPIDataSourceImpl apiService) {
        return new FeedRepositoryImpl(apiService);
    }

    @Provides @Singleton FeedAPIService provideApiService(@UserAgent final String userAgent,
                                                              Endpoint endPoint, @RetrofitLog boolean logTraces) {
        return new RestAdapter.Builder().setEndpoint(endPoint)
                .setLogLevel(logTraces ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                .setConverter(new GsonConverter(newGson()))
                .setClient(new OkClient(new OkHttpClient()))
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override public void intercept(RequestFacade requestFacade) {
                        requestFacade.addHeader("User-Agent", userAgent);
                    }
                })
                .setErrorHandler(new ErrorHandler() {
                    @Override public Throwable handleError(RetrofitError cause) {
                        Exception networkError = new Exception();
                        networkError.setStackTrace(cause.getStackTrace());
                        return networkError;
                    }
                })
                .build()
                .create(FeedAPIService.class);
    }

    public static Gson newGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }
}

