package app.clau.restaurantreservations.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import app.clau.restaurantreservations.R;


public class SplashActivity extends AppCompatActivity {

    protected void onCreate(Bundle toTheSuperClass) {
        super.onCreate(toTheSuperClass);

        Intent openLoginIntent = new Intent(this,LoginActivity.class);
        startActivity(openLoginIntent);
        finish();
    }
}
