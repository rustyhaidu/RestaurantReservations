package app.clau.restaurantreservations.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.commons.validator.routines.EmailValidator;

import app.clau.restaurantreservations.R;
import app.clau.restaurantreservations.utils.Util;

public class LoginActivity extends BaseActivity {

    private EditText mUsernameET;
    private EditText mPasswordET;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameET = findViewById(R.id.etUsernameXmlId);
        mPasswordET = findViewById(R.id.etPasswordXmlId);
        Button buttonSubmit = findViewById(R.id.btLoginId);

        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);

        final Util utils = new Util();
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAsUserName = mUsernameET.getText().toString();
                String password = mPasswordET.getText().toString();
                if (emailAsUserName.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, getString(R.string.incorrectCredentials), Toast.LENGTH_SHORT).show();
                } else if (utils.isEmailValid(emailAsUserName)) {


                    //String ediTextString = mSharedPreferences.getString(KEY_EDITTEXT,"");
                    mEditor = mSharedPreferences.edit();
                    mEditor.putString(emailAsUserName, password);
                    // mEditor.commit();
                    mEditor.apply();

                    Intent openMainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(openMainIntent);
                } else {
                    Toast.makeText(LoginActivity.this, R.string.emailFormatError, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
