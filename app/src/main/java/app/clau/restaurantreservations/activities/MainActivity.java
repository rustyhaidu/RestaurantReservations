package app.clau.restaurantreservations.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Map;

import app.clau.restaurantreservations.R;

/**
 * Created by Claudiu on 10-Nov-17.
 */

public class MainActivity extends AppCompatActivity {

    private static final String KEY_EDITTEXT = "KEY_EDITTEXT";
    private static final String PREFS_FILE = "app.clau.restaurantreservations.preferences";
    // private SharedPreferences.Editor mEditor;
    TextView mDisplayedUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDisplayedUserName = findViewById(R.id.tvMainUserNameId);

        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        //String ediTextString = sharedPreferences.getString("rustyhaidu@yahoo.com","12345678");
        Map<String, ?> allEntries = sharedPreferences.getAll();
        String ediTextString = "";
        if (allEntries.size() > 1) {
            for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
                ediTextString = ediTextString + "; " + entry.getKey();
            }
        } else {
            ediTextString = allEntries.entrySet().iterator().next().getKey();
        }


        assert ediTextString != null;
        mDisplayedUserName.setText(String.format("%s %s", getString(R.string.savedLoginText), ediTextString));


    }
}
