package app.clau.restaurantreservations.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.clau.restaurantreservations.R;

public class LoginActivity extends AppCompatActivity {

    EditText mUsernameET;
    EditText mPasswordET;
    Button mButtonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameET = findViewById(R.id.etUsernameXmlId);
        mPasswordET = findViewById(R.id.etPasswordXmlId);
        mButtonSubmit = findViewById(R.id.btLoginId);

        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUsernameET.getText().toString().isEmpty() ||
                        mPasswordET.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, getString(R.string.incorrectCredentials), Toast.LENGTH_SHORT).show();
                }else {

                }
            }
        });

    }
}
