package com.example.michael.password_validator;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This is run when the user validates the password
    public void checkPW(View view) {
        EditText editPW = (EditText) findViewById(R.id.editPassword);
        Password password = new Password(editPW.getText().toString());
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

        ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
        progress.setProgress(password.rulesApproved);

        if(password.approved) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }
    }


}
