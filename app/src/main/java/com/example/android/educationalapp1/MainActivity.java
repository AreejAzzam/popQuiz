package com.example.android.educationalapp1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int totalScore = 0;
    boolean BernRadioBox, YenRadiobox, frankRadioBox;

    public boolean radioChecked(int id) {
        RadioButton radio = (RadioButton) findViewById(id);
        boolean choices = radio.isChecked();
        return choices;
    }

    public boolean checkBoxChecked(int id) {
        CheckBox checkBox = (CheckBox) findViewById(id);
        boolean choices = checkBox.isChecked();
        return choices;
    }

    public void unchecked(int id) {
        CheckBox checkBox = (CheckBox) findViewById(id);
        if (checkBox.isChecked())
            checkBox.setChecked(false);
    }

    public void unRadio(int id) {
        RadioButton radio = (RadioButton) findViewById(id);
        radio.setChecked(false);

    }

    public void wrong(int id) {
        visable(id);
        ImageView Change = (ImageView) findViewById(id);
        Change.setImageResource(R.drawable.wrong);
    }

    public void correct(int id) {
        visable(id);
        ImageView Change = (ImageView) findViewById(id);
        Change.setImageResource(R.drawable.correct);


    }

    public void visable(int id) {
        ImageView imgView = (ImageView) findViewById(id);
        imgView.setVisibility(View.VISIBLE);
    }

    public void invisable(int id) {
        ImageView imgView = (ImageView) findViewById(id);
        imgView.setVisibility(View.INVISIBLE);
    }

    public void question1answer() {
        BernRadioBox = radioChecked(R.id.bern);
        invisable(R.id.ans1_ImageView);
        if (BernRadioBox == true) {
            totalScore += 15;
            correct(R.id.ans1_ImageView);
        } else {
            wrong(R.id.ans1_ImageView);
        }

    }

    public void question2answer() {
        invisable(R.id.ans2_ImageView);
        boolean Box1Ans = checkBoxChecked(R.id.a1);
        boolean Box2Ans = checkBoxChecked(R.id.a2);
        boolean Box3Ans = checkBoxChecked(R.id.a3);
        boolean Box4Ans = checkBoxChecked(R.id.a4);
        boolean Box5Ans = checkBoxChecked(R.id.a5);
        if (Box1Ans == true && Box3Ans == true && Box5Ans == true && Box4Ans == false && Box2Ans == false) {
            totalScore += 15;
            correct(R.id.ans2_ImageView);
        } else
            wrong(R.id.ans2_ImageView);

    }

    public void question3answer() {
        invisable(R.id.ans3_ImageView);
        YenRadiobox = radioChecked(R.id.yen);
        RadioButton radio1 = (RadioButton) findViewById(R.id.yen);
        if (YenRadiobox) {
            totalScore += 15;
            correct(R.id.ans3_ImageView);
        } else {
            wrong(R.id.ans3_ImageView);
        }
    }

    public void question4answer() {
        invisable(R.id.ans4_ImageView);
        frankRadioBox = radioChecked(R.id.frank);
        if (frankRadioBox) {
            totalScore += 15;
            correct(R.id.ans4_ImageView);
        } else {
            wrong(R.id.ans4_ImageView);
        }
    }

    public void question5answer() {
        invisable(R.id.ans5_ImageView);
        int sevenContinents=-1;
       EditText numOfContinents = (EditText) findViewById(R.id.NumberOfContinents);
       if(numOfContinents.getText().toString().length()>0)
        sevenContinents = Integer.parseInt(numOfContinents.getText().toString());
        if (sevenContinents==7) {
            totalScore += 15;
            correct(R.id.ans5_ImageView);
        }
        else {
            wrong(R.id.ans5_ImageView);
        }
    }

    public void submit(View view) {
        question1answer();
        question2answer();
        question3answer();
        question4answer();
        question5answer();
        Toast.makeText(MainActivity.this, "totalScore" + totalScore, Toast.LENGTH_LONG).show();
        totalScore = 0;
    }

    public void reset(View view) {
        invisable(R.id.ans1_ImageView);
        invisable(R.id.ans2_ImageView);
        invisable(R.id.ans3_ImageView);
        invisable(R.id.ans4_ImageView);
        invisable(R.id.ans5_ImageView);
        totalScore = 0;
        unchecked(R.id.a1);
        unchecked(R.id.a2);
        unchecked(R.id.a3);
        unchecked(R.id.a4);
        unchecked(R.id.a5);
        unRadio(R.id.bern);
        unRadio(R.id.canberra);
        unRadio(R.id.frank);
        unRadio(R.id.merkel);
        unRadio(R.id.sigmar);
        unRadio(R.id.yen);
        unRadio(R.id.franc);
        unRadio(R.id.renminbi);
        unRadio(R.id.phnom);

    }
}
