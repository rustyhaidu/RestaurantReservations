package app.clau.restaurantreservations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {
    public ActionBar actionBar;

    protected void onCreate(Bundle toTheSuperClass) {
        super.onCreate(toTheSuperClass);
        setContentView(R.layout.activity_splash);  //xml splash
        actionBar = getSupportActionBar();
        actionBar.hide();
        //Thread urmeaza timer

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent openMainIntent = new Intent();
                    openMainIntent.setClass(SplashActivity.this,MainActivity.class);
                    startActivity(openMainIntent);
                }

            }
        };
        timer.start();
    }

    protected void onPause() {
        super.onPause();
        finish();
    }
}
