package com.example.android.quiz_final;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class startScreen extends AppCompatActivity {
    /*
        here I am declaring global variable to be able to use it in all views
    */
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }

    public void onClick(View view) {
    /*
            Here I am collecting user input Name
    */
        EditText editText = (EditText) findViewById(R.id.editText);
        String name = editText.getText().toString();
        /*
                This if else statment provides error if name field is empty
        */
        if (editText.getText().toString().length() == 0) {
            editText.setError("First name is required!");
        } else {
            /*
                        Here I am storing name to global variable so i can use it in all views in my case I will use it in end activity
            */
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("name", name);
            editor.apply();
            /*
                        Now  i create new intent to start next activity
            */
            Intent myIntent = new Intent(view.getContext(), com.example.android.quiz_final.MainActivity.class);
            /*
                        I finish this activity so if someone wants to do test more than one time. or give a friend to fill. he needs to enter name again
            */
            finish();
            /*
                        and now I start next activity MainActivity
            */
            startActivity(myIntent);
        }
    }
}
