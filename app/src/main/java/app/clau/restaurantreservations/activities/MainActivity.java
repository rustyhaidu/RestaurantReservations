package app.clau.restaurantreservations.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import app.clau.restaurantreservations.R;
import app.clau.restaurantreservations.models.BaseTable;
import app.clau.restaurantreservations.models.NoSmokingTable;
import app.clau.restaurantreservations.models.SmokingTable;
import app.clau.restaurantreservations.models.VIPTable;

/**
 * Created by Claudiu on 10-Nov-17.
 */

public class MainActivity extends AppCompatActivity {

    ListView list;
    private List<BaseTable> myTables = new ArrayList<BaseTable>();

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
                ediTextString = entry.getKey() + "; " + ediTextString;
            }
        } else {
            ediTextString = allEntries.entrySet().iterator().next().getKey();
        }


        assert ediTextString != null;
        mDisplayedUserName.setText(String.format("%s %s", getString(R.string.savedLoginText), ediTextString));

        list = findViewById(R.id.listView);
        populateTableList();
        populateListView();
    }

    private void populateListView() {
        ArrayAdapter<BaseTable> adapter = new MyListAdapter();
        // ListView list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);
    }


    private void populateTableList() {
        myTables.add(new NoSmokingTable(1));
        myTables.add(new SmokingTable(2));
        myTables.add(new VIPTable(3));
        myTables.add(new BaseTable(4));
        myTables.add(new BaseTable(5));
    }

    private class MyListAdapter extends ArrayAdapter<BaseTable> {

        public MyListAdapter() {
            super(MainActivity.this, R.layout.item_view, myTables);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;

            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }
            BaseTable currentTable = myTables.get(position);
            TextView tvTextNumber = itemView.findViewById(R.id.textNumber);
            tvTextNumber.setText(String.valueOf(currentTable.getNumber()));

            return itemView;
        }
    }
}
