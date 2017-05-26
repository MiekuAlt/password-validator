package com.example.michael.password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        // Initializing the variables
        EditText editPW = (EditText) findViewById(R.id.editPassword);
        Password password = new Password(editPW.getText().toString());
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);

        // Updating the progress bar with the number of rules accepted
        progress.setProgress(password.rulesApproved);

        // Checks the checkbox if the password was approved
        if(password.approved) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }
    }
}
