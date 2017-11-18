package app.clau.restaurantreservations.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import java.util.Map;

import app.clau.restaurantreservations.R;


public class SplashActivity extends BaseActivity {

    private SharedPreferences sharedPreferences;
    private static final String PREFS_FILE = "app.clau.restaurantreservations.preferences";

    protected void onCreate(Bundle toTheSuperClass) {
        super.onCreate(toTheSuperClass);

        sharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        Map<String, ?> allEntries = sharedPreferences.getAll();

        if (allEntries.size() > 0) {
            Intent openMainIntent = new Intent(this, MainActivity.class);
            startActivity(openMainIntent);
            finish();

        } else {
            Intent openLoginIntent = new Intent(this, LoginActivity.class);
            startActivity(openLoginIntent);
            finish();
        }

    }
}
