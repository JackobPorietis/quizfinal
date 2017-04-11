package com.example.android.quiz_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {
    //defined TextViews
    TextView mTextview;
    TextView mTextview2;
    TextView mTextview3;
    TextView mTextview4;
    TextView mTextview5;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        //finding TextView and passing data from MainActivity
        mTextview = (TextView) findViewById(R.id.textView1);
        mTextview.setText(getIntent().getStringExtra("text"));
        mTextview2 = (TextView) findViewById(R.id.textView2);
        mTextview2.setText(getIntent().getStringExtra("text2"));
        mTextview3 = (TextView) findViewById(R.id.textView3);
        mTextview3.setText(getIntent().getStringExtra("text3"));
        mTextview4 = (TextView) findViewById(R.id.textView4);
        mTextview4.setText(getIntent().getStringExtra("text4"));
        mTextview5 = (TextView) findViewById(R.id.textView5);
        mTextview5.setText(getIntent().getStringExtra("text5"));
    }


    public void pressed(View view) {
        //starting question activity on press
        Intent Intent3 = new Intent(view.getContext(), question_activity.class);
        //ending activity2
        finish();
        //launching new activity question_activity
        startActivity(Intent3);

    }

    /*This is interesting I override default onBackPressed to restart previous activity
            so my point counter will work correctly only downside you need to answer to all questions again */
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        super.onBackPressed();

    }
}