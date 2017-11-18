package app.clau.restaurantreservations.activities;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Claudiu on 16-Nov-17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected static final String PREFS_FILE = "app.clau.restaurantreservations.preferences";
    protected SharedPreferences mSharedPreferences;
    protected SharedPreferences.Editor mEditor;
}
