package com.dylansalim.aboutmyself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class ResultActivity extends AppCompatActivity {
    LottieAnimationView mAnimationView;
    TextView mResultTitle;
    TextView mResultDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        boolean isPass = getIntent().getBooleanExtra("PASS_STATUS", true);
        mAnimationView = findViewById(R.id.animationView);
        mResultTitle = findViewById(R.id.resultTitle);
        mResultDesc = findViewById(R.id.resultDescription);
        if (!isPass) {
            mAnimationView.setAnimation(R.raw.incorrect_animation);
            Resources res = getResources();
            String title = res.getString(R.string.incorrectTitle);
            String desc = res.getString(R.string.incorrectDesc);
            mResultTitle.setText(title);
            mResultDesc.setText(desc);
        }

    }

    public void backToPreviousPage(View v) {
        Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}