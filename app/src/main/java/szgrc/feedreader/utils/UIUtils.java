package szgrc.feedreader.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by gonzalofernandez on 11/08/15.
 */
public class UIUtils {

    public static void showLongSnackbar(View v, String message){
        Snackbar.make(v, message, Snackbar.LENGTH_LONG).show();
    }

    public static void showShortSnackbar(View v, String message){
        Snackbar.make(v, message, Snackbar.LENGTH_SHORT).show();
    }
}
