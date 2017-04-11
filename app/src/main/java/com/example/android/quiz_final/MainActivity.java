package com.example.android.quiz_final;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    /*
        This string will save question points and question text, question text will not be used further it's more for my training to use global strings
    */
    public static final String q1 = "MyPrefsFile";
    /*
        This variable save first 5 questions points
    */
    int firstPagePoints = 0;
    TextView t;
    /*
        here is defined radio groups for my quiz to work in each group there will be from two to five radio buttons
    */
    private RadioGroup radioGroup;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private RadioGroup radioGroup4;
    private RadioGroup radioGroup5;
    private RadioButton radioButton;
    private Button btnDisplay;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
                 here I am creating listener to my button, it allows me to do more functions with button
        */
        addListenerOnButton();
        /*
                Here I am making strings and save them as global variables qq1 stands for question 1 in question global string and so on
        */
        String qq1 = "Which is the capital Of Latvia? ";
        SharedPreferences settings = getSharedPreferences(q1, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("Which is the capital Of Latvia? ", qq1);
        editor.apply();
        /*
                Here i am applying string to my TextView
        */
        t = (TextView) findViewById(R.id.radiotext1);
        t.setText(qq1);

        String qq2 = "Which is the biggest national park in Latvia? ";
        editor.putString("Which is the biggest national park in Latvia? ", qq2);
        editor.apply();
        t = (TextView) findViewById(R.id.radiotext2);
        t.setText(qq2);

        String qq3 = "How big is the territory of Latvia in square feet? ";
        editor.putString("How big is the territory of Latvia in square feet? ", qq3);
        editor.apply();
        t = (TextView) findViewById(R.id.radiotext3);
        t.setText(qq3);

        String qq4 = "How tall is an average woman in Latvia ? ";
        editor.putString("How tall are average Latvian laddies?  ", qq4);
        editor.apply();
        t = (TextView) findViewById(R.id.radiotext4);
        t.setText(qq4);

        String qq5 = "In which place is Latvia ranked by its internet speed";
        editor.putString("In which place is Latvia ranked by its internet speed ", qq5);
        editor.apply();
        t = (TextView) findViewById(R.id.radiotext5);
        t.setText(qq5);
    }

    public void addListenerOnButton() {
        /*
                Here I am declering which radio group owns which xml layout
        */
        radioGroup = (RadioGroup) findViewById(R.id.group1);
        radioGroup2 = (RadioGroup) findViewById(R.id.group2);
        radioGroup3 = (RadioGroup) findViewById(R.id.group3);
        radioGroup4 = (RadioGroup) findViewById(R.id.group4);
        radioGroup5 = (RadioGroup) findViewById(R.id.group5);
        /*
                btsDisplay is user pressable button
        */
        btnDisplay = (Button) findViewById(R.id.btnDisplay);
        btnDisplay.setOnClickListener(new OnClickListener() {


            public void onClick(View view) {
        /*
                        This if statment is for showing error if you didn't answered to question but try to get to next page
        */
                if (radioGroup.getCheckedRadioButtonId() <= 0) {
                    t = (TextView) findViewById(R.id.radiotext1);
                    t.setError("ERROR");
                    Toast.makeText(getApplicationContext(), "Please Answer all questions!",
                            Toast.LENGTH_LONG).show();
                }
                /*
                                If you answered there will not be an error
                */
                if (radioGroup.getCheckedRadioButtonId() > 0) {
                    t.setError(null);
                    if (radioGroup2.getCheckedRadioButtonId() <= 0) {
                        t = (TextView) findViewById(R.id.radiotext2);
                        t.setError("ERROR");
                        Toast.makeText(getApplicationContext(), "Please Answer all questions!",
                                Toast.LENGTH_LONG).show();
                    }
                    if (radioGroup2.getCheckedRadioButtonId() > 0) {
                        t.setError(null);
                        if (radioGroup3.getCheckedRadioButtonId() <= 0) {
                            t = (TextView) findViewById(R.id.radiotext3);
                            t.setError("ERROR");
                            Toast.makeText(getApplicationContext(), "Please Answer all questions!",
                                    Toast.LENGTH_LONG).show();
                        }
                        if (radioGroup3.getCheckedRadioButtonId() > 0) {
                            t.setError(null);
                            if (radioGroup4.getCheckedRadioButtonId() <= 0) {
                                t = (TextView) findViewById(R.id.radiotext4);
                                t.setError("ERROR");
                                Toast.makeText(getApplicationContext(), "Please Answer all questions!",
                                        Toast.LENGTH_LONG).show();
                            }
                            if (radioGroup4.getCheckedRadioButtonId() > 0) {
                                t.setError(null);

                                if (radioGroup5.getCheckedRadioButtonId() <= 0) {
                                    t = (TextView) findViewById(R.id.radiotext5);
                                    t.setError("ERROR");
                                    Toast.makeText(getApplicationContext(), "Please Answer all questions!",
                                            Toast.LENGTH_LONG).show();
                                }
                                if (radioGroup5.getCheckedRadioButtonId() > 0) {
                                    t.setError(null);
                                    // Here I start new Intent for activity to pass necessary code to next view
                                    Intent myIntent = new Intent(view.getContext(), com.example.android.quiz_final.activity2.class);
                                    // get selected radio button from radioGroup
                                    int selectedId = radioGroup.getCheckedRadioButtonId();
                                    int selectedId2 = radioGroup2.getCheckedRadioButtonId();
                                    int selectedId3 = radioGroup3.getCheckedRadioButtonId();
                                    int selectedId4 = radioGroup4.getCheckedRadioButtonId();
                                    int selectedId5 = radioGroup5.getCheckedRadioButtonId();
                                    // find the radiobutton by returned id
                                    radioButton = (RadioButton) findViewById(selectedId);
                                    //strings that will be passed to next activity
                                    String Correct = "Your answer was correct The capital of Latvia really is Riga ";
                                    String Wrong = "Nope , The capital of Latvia is Riga";
                                    // statements for getting know if answer is correct or not
                                    if (selectedId == R.id.radio2) {
                                        //passing
                                        myIntent.putExtra("text", Wrong);

                                    }
                                    if (selectedId == R.id.radio3) {
                                        //For counting correct answers
                                        firstPagePoints = firstPagePoints + 1;
                                        myIntent.putExtra("text", Correct);

                                    }
                                    radioButton = (RadioButton) findViewById(selectedId2);
                                    String Correct2 = "The biggest National park in Latvia is Gaujas National park. You answered Correctly  :)";
                                    String Wrong2 = "Nope, The biggest National park in Latvia is Gaujas National park. ";
                                    if (selectedId2 == R.id.radio4) {
                                        myIntent.putExtra("text2", Wrong2);
                                    }
                                    if (selectedId2 == R.id.radio5) {
                                        myIntent.putExtra("text2", Correct2);
                                        firstPagePoints = firstPagePoints + 1;
                                    }
                                    if (selectedId2 == R.id.radio6) {
                                        myIntent.putExtra("text2", Wrong2);
                                    }
                                    radioButton = (RadioButton) findViewById(selectedId3);
                                    String Correct3 = "64 589 km² is correct answer";
                                    String Wrong3 = "Nope, the right answer is 64 589 km²";
                                    if (selectedId3 == R.id.radio7) {
                                        myIntent.putExtra("text3", Wrong3);
                                    }
                                    if (selectedId3 == R.id.radio8) {
                                        myIntent.putExtra("text3", Correct3);
                                        firstPagePoints = firstPagePoints + 1;
                                    }
                                    radioButton = (RadioButton) findViewById(selectedId4);
                                    String Correct4 = "In Latvia there are the tallest women in the world with average height of 170 , and they are the most beautiful, too :) ";
                                    String Wrong4 = "Nope, in Latvia there are the tallest women in the world with average height of 170 , and they are the most beautiful, too :)";
                                    if (selectedId4 == R.id.radio10) {
                                        myIntent.putExtra("text4", Correct4);
                                        firstPagePoints = firstPagePoints + 1;
                                    }
                                    if (selectedId4 == R.id.radio11) {
                                        myIntent.putExtra("text4", Wrong4);

                                    }
                                    if (selectedId4 == R.id.radio12) {
                                        myIntent.putExtra("text4", Wrong4);
                                    }
                                    radioButton = (RadioButton) findViewById(selectedId5);
                                    String Correct5 = "Correct, in Latvia average speed of internet is 18.3 Mbps. So that makes us in 6th place global";
                                    String Wrong5 = " Nope, in Latvia average speed of internet is 18.3 Mbps. So that makes us in 6th place global";
                                    if (selectedId5 == R.id.radio13) {
                                        myIntent.putExtra("text5", Wrong5);
                                    }
                                    if (selectedId5 == R.id.radio14) {
                                        myIntent.putExtra("text5", Wrong5);
                                    }
                                    if (selectedId5 == R.id.radio15) {
                                        myIntent.putExtra("text5", Correct5);
                                        firstPagePoints = firstPagePoints + 1;
                                    }
                                    if (selectedId5 == R.id.radio16) {
                                        myIntent.putExtra("text5", Wrong5);
                                    }
                                    //pass result to global variable converting integer to string
                                    SharedPreferences settings1 = getSharedPreferences(q1, Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = settings1.edit();
                                    String firstPagePointsR = Integer.toString(firstPagePoints);
                                    editor.putString("firstPagePoints", firstPagePointsR);
                                    editor.apply();
                                    //This will show to how many questions you answered correctly but toast will appear in next acclivity
                                    Toast.makeText(getApplicationContext(), "You Answered Correctly to " + firstPagePoints + " questions out of 5",
                                            Toast.LENGTH_LONG).show();
                                    //end activity
                                    finish();
                                    // starting next activity activity2
                                    startActivity(myIntent);

                                }
                            }
                        }
                    }
                }
            }
        });
    }

    public void onBackPressed() {
        startActivity(new Intent(this, startScreen.class));
        super.onBackPressed();

    }
}
