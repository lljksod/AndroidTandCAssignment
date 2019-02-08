package com.rburch.androidtandcassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name, email, password, confirmPassword;
    private CheckBox agree;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.enterNameBox);
        email = findViewById(R.id.enterEmailBox);
        password = findViewById(R.id.enterPassword);
        confirmPassword = findViewById(R.id.confirmPassword);
        agree = findViewById(R.id.checkBox);
        Button signup = findViewById(R.id.button);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sname = name.getText().toString();
                String semail = email.getText().toString();
                String spass = password.getText().toString();
                String sconf = confirmPassword.getText().toString();

                if(TextUtils.isEmpty(sname)) {
                    name.setError("Name can not be empty.");
                }
                if(TextUtils.isEmpty(semail)) {
                    email.setError("Email can not be empty.");
                }
                if(TextUtils.isEmpty(spass)) {
                    password.setError("Password can not be empty.");
                }
                if(TextUtils.isEmpty(sconf)) {
                    confirmPassword.setError("Confirm Password can not be empty.");
                }

                if(agree.isChecked() && (name.getError() == null) && (email.getError() == null)
                && (password.getError() == null) && (confirmPassword.getError() == null)) {
                    Log.w("debug", name.getText().toString());
                    Log.w("debug", email.getText().toString());
                    Log.w("debug", password.getText().toString());
                    Log.w("debug", confirmPassword.getText().toString());
                } else if(!agree.isChecked()){
                    Toast.makeText(getBaseContext(), "You must agree!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



}
