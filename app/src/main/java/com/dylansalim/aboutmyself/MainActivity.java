package com.dylansalim.aboutmyself;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    RadioButton mRadioButton1;
    RadioButton mRadioButton2;
    RadioButton mRadioButton3;
    RadioGroup mRadioGroup;
    Button mBackButton;
    MaterialButton mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadioButton1 = findViewById(R.id.radio0);
        mRadioButton2 = findViewById(R.id.radio1);
        mRadioButton3 = findViewById(R.id.radio2);
        mBackButton = findViewById(R.id.main_back_btn);
        mSubmitButton = findViewById(R.id.submit_btn);
        mRadioGroup = findViewById(R.id.radioGroup);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPrefsData();
                Intent mainActivity = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(mainActivity);
                finish();
            }
        });

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                if(mRadioGroup.getCheckedRadioButtonId()==-1){

                }else{
                    intent.putExtra("PASS_STATUS", isAnswerCorrect());
                    startActivity(intent);
                    finish();
                }

            }
        });


    }

    private boolean isAnswerCorrect() {
        int checkedRadioId = mRadioGroup.getCheckedRadioButtonId();
        System.out.println("checked RADIO ID: "+checkedRadioId);

        int correctAnswerId = mRadioButton2.getId();
        System.out.println("correct RADIO ID: "+correctAnswerId);

        return checkedRadioId == correctAnswerId;
    }

    private void resetPrefsData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpnend", false);
        editor.apply();


    }
}