package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class GenderActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton maleButton;
    private RadioButton femaleButton;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        maleButton = findViewById(R.id.male);
        femaleButton = findViewById(R.id.female);
        findViewById(R.id.check).setOnClickListener(this);
        pref = getSharedPreferences("exam", MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        genderOK();
    }

    public void genderOK() {
        if (maleButton.isChecked()) {
            pref.edit()
                    .putString("GENDER", maleButton.getText().toString())
                    .commit();
        } else if (femaleButton.isChecked()) {
            pref.edit()
                    .putString("GENDER", femaleButton.getText().toString())
                    .commit();
        }
        if (maleButton.isChecked() || femaleButton.isChecked()) {
            Intent intent = new Intent();
            intent.setClass(GenderActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            new AlertDialog.Builder(GenderActivity.this)
                    .setTitle("錯誤")
                    .setMessage("請選擇一項, 謝謝!")
                    .setPositiveButton("OK", null)
                    .show();
        }
    }
}
