package app.clau.restaurantreservations.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import app.clau.restaurantreservations.R;
import app.clau.restaurantreservations.adaptars.TableAdapter;
import app.clau.restaurantreservations.models.BaseTable;
import app.clau.restaurantreservations.models.NoSmokingTable;
import app.clau.restaurantreservations.models.SmokingTable;
import app.clau.restaurantreservations.models.VIPTable;

/**
 * Created by Claudiu on 10-Nov-17.
 */

public class MainActivity extends BaseActivity {

    private ListView list;
    private List<BaseTable> myTables = new ArrayList<BaseTable>();
    private TextView mEmptyTextView;

    private static final String PREFS_FILE = "app.clau.restaurantreservations.preferences";
    TextView mDisplayedUserNameId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button logoutButton = findViewById(R.id.btLogout);
        mDisplayedUserNameId = findViewById(R.id.tvMainUserNameId);
        mEmptyTextView = findViewById(R.id.textNumber);

        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);

        Map<String, ?> allEntries = mSharedPreferences.getAll();
        String ediTextString = "";
        if (allEntries.size() > 1) {
            for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
                ediTextString = entry.getKey() + "; " + ediTextString;
            }
        } else {
            ediTextString = allEntries.entrySet().iterator().next().getKey();
        }
        mDisplayedUserNameId.setText(String.format("%s %s", getString(R.string.savedLoginText), ediTextString));

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.clear();
                editor.apply();

                Intent openSpalshIntent = new Intent(MainActivity.this, SplashActivity.class);
                startActivity(openSpalshIntent);
                finish();
            }
        });

        list = findViewById(R.id.listView);
        populateTableList();
        populateListView();


    }

    private void populateListView() {
        TableAdapter adapter = new TableAdapter(this, myTables);
        list.setAdapter(adapter);
        list.setEmptyView(mEmptyTextView);
    }


    private void populateTableList() {
        myTables.add(new NoSmokingTable(1));
        myTables.add(new SmokingTable(2));
        myTables.add(new VIPTable(3));
        myTables.add(new BaseTable(4));
        myTables.add(new BaseTable(5));
    }
}
