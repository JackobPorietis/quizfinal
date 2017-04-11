package com.example.android.quiz_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//And so here is same logic as in activity2, next activity end_activity
public class activity3 extends AppCompatActivity {
    TextView mTextview7;
    TextView mTextview8;
    TextView mTextview9;
    TextView mTextview10;
    TextView mTextview11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);
        mTextview7 = (TextView) findViewById(R.id.textView7);
        mTextview7.setText(getIntent().getStringExtra("text6"));
        mTextview8 = (TextView) findViewById(R.id.textView8);
        mTextview8.setText(getIntent().getStringExtra("text7"));
        mTextview9 = (TextView) findViewById(R.id.textView9);
        mTextview9.setText(getIntent().getStringExtra("text8"));
        mTextview10 = (TextView) findViewById(R.id.textView10);
        mTextview10.setText(getIntent().getStringExtra("text9"));
        mTextview11 = (TextView) findViewById(R.id.textView11);
        mTextview11.setText(getIntent().getStringExtra("text10"));
    }

    public void pressed(View view) {
        Intent Intent4 = new Intent(view.getContext(), end_activity.class);
        finish();
        startActivity(Intent4);
    }

    public void onBackPressed() {
        startActivity(new Intent(this, question_activity.class));
        super.onBackPressed();

    }
}