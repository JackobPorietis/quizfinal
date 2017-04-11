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

//Here is same Logic as in MainActivity just next five questions next activity launched will be activity3
public class question_activity extends AppCompatActivity {
    public static final String q2 = "MyPrefsFile";
    int secondPagePoints = 0;
    private RadioGroup radioGroup6;
    private RadioGroup radioGroup7;
    private RadioGroup radioGroup8;
    private RadioGroup radioGroup9;
    private RadioGroup radioGroup10;
    private RadioButton radioButton;
    private Button btnDisplay;
    TextView t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_activity);

        addListenerOnButton();
        String qq6 = "Which is the most popular sport in Latvia? ";
        SharedPreferences settings = getSharedPreferences(q2, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("Which is the most popular sport in Latvia? ", qq6);
        editor.apply();
        t = (TextView) findViewById(R.id.radiotext6);
        t.setText(qq6);

        String qq7 = "Part of the territory of Latvia is covered in forests. How big is it?  ";
        editor.putString("Part of the territory of Latvia is covered in forests. How big is it?", qq7);
        editor.apply();
        t = (TextView) findViewById(R.id.radiotext7);
        t.setText(qq7);

        String qq8 = "Which is cheaper in Latvia milk or beer?  ";
        editor.putString("Which is cheaper in Latvia milk or beer?  ", qq8);
        editor.apply();
        t = (TextView) findViewById(R.id.radiotext8);
        t.setText(qq8);

        String qq9 = "Which is the widest waterfall in Latvia? ";
        editor.putString("Which is the widest waterfall in Latvia? ", qq9);
        editor.apply();
        t = (TextView) findViewById(R.id.radiotext9);
        t.setText(qq9);

        String qq10 = "Who invented Jeans ? ";
        editor.putString("Who invented Jeans ? ", qq10);
        editor.apply();
        t = (TextView) findViewById(R.id.radiotext10);
        t.setText(qq10);


    }

    public void addListenerOnButton() {


        radioGroup6 = (RadioGroup) findViewById(R.id.group6);
        radioGroup7 = (RadioGroup) findViewById(R.id.group7);
        radioGroup8 = (RadioGroup) findViewById(R.id.group8);
        radioGroup9 = (RadioGroup) findViewById(R.id.group9);
        radioGroup10 = (RadioGroup) findViewById(R.id.group10);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);
        btnDisplay.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {

                if (radioGroup6.getCheckedRadioButtonId() <= 0) {
                    t = (TextView) findViewById(R.id.radiotext6);
                    t.setError("ERROR");
                    Toast.makeText(getApplicationContext(), "Please Answer all questions!",
                            Toast.LENGTH_LONG).show();
                }
                if (radioGroup6.getCheckedRadioButtonId() > 0) {
                    t.setError(null);

                    if (radioGroup7.getCheckedRadioButtonId() <= 0) {
                        t = (TextView) findViewById(R.id.radiotext7);
                        t.setError("ERROR");
                        Toast.makeText(getApplicationContext(), "Please Answer all questions!",
                                Toast.LENGTH_LONG).show();
                    }
                    if (radioGroup7.getCheckedRadioButtonId() > 0) {
                        t.setError(null);

                        if (radioGroup8.getCheckedRadioButtonId() <= 0) {
                            t = (TextView) findViewById(R.id.radiotext8);
                            t.setError("ERROR");
                            Toast.makeText(getApplicationContext(), "Please Answer all questions!",
                                    Toast.LENGTH_LONG).show();
                        }
                        if (radioGroup8.getCheckedRadioButtonId() > 0) {
                            t.setError(null);

                            if (radioGroup9.getCheckedRadioButtonId() <= 0) {
                                t = (TextView) findViewById(R.id.radiotext9);
                                t.setError("ERROR");
                                Toast.makeText(getApplicationContext(), "Please Answer all questions!",
                                        Toast.LENGTH_LONG).show();
                            }
                            if (radioGroup9.getCheckedRadioButtonId() > 0) {
                                t.setError(null);

                                if (radioGroup10.getCheckedRadioButtonId() <= 0) {
                                    t = (TextView) findViewById(R.id.radiotext10);
                                    t.setError("ERROR");
                                    Toast.makeText(getApplicationContext(), "Please Answer all questions!",
                                            Toast.LENGTH_LONG).show();
                                }
                                if (radioGroup10.getCheckedRadioButtonId() > 0) {
                                    t.setError(null);


                                    Intent Intent3 = new Intent(view.getContext(), com.example.android.quiz_final.activity3.class);

                                    // get selected radio button from radioGroup
                                    int selectedId6 = radioGroup6.getCheckedRadioButtonId();
                                    int selectedId7 = radioGroup7.getCheckedRadioButtonId();
                                    int selectedId8 = radioGroup8.getCheckedRadioButtonId();
                                    int selectedId9 = radioGroup9.getCheckedRadioButtonId();
                                    int selectedId10 = radioGroup10.getCheckedRadioButtonId();


                                    // find the radiobutton by returned id
                                    radioButton = (RadioButton) findViewById(selectedId6);
                                    String Correct6 = "Yes,  hockey is the most popular sport in Latvia!";
                                    String Wrong6 = "Nope,  sorry but the most popular sport in Latvia is Hockey ";

                                    if (selectedId6 == R.id.radio20) {

                                        Intent3.putExtra("text6", Correct6);
                                        secondPagePoints = secondPagePoints + 1;

                                    }
                                    if (selectedId6 == R.id.radio21) {
                                        Intent3.putExtra("text6", Wrong6);
                                    }
                                    if (selectedId6 == R.id.radio22) {
                                        Intent3.putExtra("text6", Wrong6);
                                    }

                                    radioButton = (RadioButton) findViewById(selectedId7);
                                    String Correct7 = "Correct, aren't you a smart one? Forest really covers half Latvia:)";
                                    String Wrong7 = "Nope, forest covers half Latvia be more careful :) ";

                                    if (selectedId7 == R.id.radio23) {
                                        Intent3.putExtra("text7", Correct7);
                                        secondPagePoints = secondPagePoints + 1;
                                    }
                                    if (selectedId7 == R.id.radio24) {
                                        Intent3.putExtra("text7", Wrong7);
                                    }

                                    radioButton = (RadioButton) findViewById(selectedId8);
                                    String Correct8 = "Yes indeed, as wrong as it is, in Latvia you can get beer cheaper than milk";
                                    String Wrong8 = "Nope, Latvians love so much beer than it is cheaper than milk";

                                    if (selectedId8 == R.id.radio25) {
                                        Intent3.putExtra("text8", Wrong8);
                                    }
                                    if (selectedId8 == R.id.radio26) {
                                        secondPagePoints = secondPagePoints + 1;
                                        Intent3.putExtra("text8", Correct8);
                                    }

                                    radioButton = (RadioButton) findViewById(selectedId9);
                                    String Correct9 = "Yes, It is the widest waterfall not only in Latvia but in Europe, too!  ";
                                    String Wrong9 = "Nope, Ventas Rumba is the widest waterfall not only in Latvia but in Europe, too! ";

                                    if (selectedId9 == R.id.radio27) {
                                        secondPagePoints = secondPagePoints + 1;
                                        Intent3.putExtra("text9", Correct9);
                                    }
                                    if (selectedId9 == R.id.radio28) {
                                        Intent3.putExtra("text9", Wrong9);
                                    }
                                    if (selectedId9 == R.id.radio29) {
                                        Intent3.putExtra("text9", Wrong9);
                                    }

                                    radioButton = (RadioButton) findViewById(selectedId10);
                                    String Correct10 = "Correct, wasn't so tricky, was it?";
                                    String Wrong10 = "Nope, Jackob Devis invented Jeans ;) ";

                                    if (selectedId10 == R.id.radio30) {
                                        Intent3.putExtra("text10", Wrong10);
                                    }
                                    if (selectedId10 == R.id.radio31) {
                                        Intent3.putExtra("text10", Wrong10);
                                    }
                                    if (selectedId10 == R.id.radio32) {
                                        Intent3.putExtra("text10", Wrong10);
                                    }
                                    if (selectedId10 == R.id.radio33) {
                                        secondPagePoints = secondPagePoints + 1;
                                        Intent3.putExtra("text10", Correct10);
                                    }
                                    SharedPreferences settings = getSharedPreferences(q2, Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = settings.edit();
                                    String secondPagePointsR = Integer.toString(secondPagePoints);
                                    editor.putString("secondPagePoints", secondPagePointsR);
                                    editor.apply();
                                    //This will show to how many questions you answered correctly but toast will appear in next acclivity
                                    Toast.makeText(getApplicationContext(), "You Answered Correctly to " + secondPagePoints + " questions out of 5",
                                            Toast.LENGTH_LONG).show();
                                    finish();
                                    //starting activity3
                                    startActivity(Intent3);

                                }
                            }
                        }
                    }
                }
            }
        });
    }

    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        super.onBackPressed();

    }
}


