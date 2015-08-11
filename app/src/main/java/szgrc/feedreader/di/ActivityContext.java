package szgrc.feedreader.di;

import java.lang.annotation.Retention;
import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by gonzalofernandez on 11/08/15.
 */
@Qualifier @Retention(RUNTIME)
public @interface ActivityContext {
}
