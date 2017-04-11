package com.example.android.quiz_final;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
//Importing global Strings
import static com.example.android.quiz_final.startScreen.PREFS_NAME;
import static com.example.android.quiz_final.question_activity.q2;
import static com.example.android.quiz_final.MainActivity.q1;

public class end_activity extends AppCompatActivity {
    TextView t;

    public void points() {
        //logic to revive strings and display total points - correct answers
        SharedPreferences settings = getSharedPreferences(q2, Context.MODE_PRIVATE);
        String secondPagePointsR = settings.getString("secondPagePoints", " ");
        SharedPreferences settings1 = getSharedPreferences(q1, Context.MODE_PRIVATE);
        String firstPagePointsR = settings1.getString("firstPagePoints", " ");
        int firstPoints = Integer.parseInt(firstPagePointsR);
        int secondPoints = Integer.parseInt(secondPagePointsR);
        int totalPoints = firstPoints + secondPoints;
        t = (TextView) findViewById(R.id.result);
        t.setText(" You answered correctly to " + totalPoints + " of 10 questions. Congrats!:) ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_activity);
        //Displaying result
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String name = settings.getString("name", "");
        t = (TextView) findViewById(R.id.textView);
        t.setText(name + getString(R.string.yey));
        points();
    }

    @Override
    public void onBackPressed() {
        //restart app to startScreen
        startActivity(new Intent(this, startScreen.class));
        super.onBackPressed();

    }
}


/*
Thank you Udacity for this amazing course.
I hope you enjoy my quiz app.
I didn't even know that I can learn so much in so little time!:))
*/


