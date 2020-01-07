package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edAge;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        edAge = findViewById(R.id.age);
        findViewById(R.id.next2).setOnClickListener(this);
        pref = getSharedPreferences("exam", MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        ageOK();
    }

    public void ageOK() {
        pref.edit()
                .putString("AGE", edAge.getText().toString())
                .commit();
        if (!edAge.getText().toString().equals("")) {
            Intent intent = new Intent();
            intent.setClass(AgeActivity.this, GenderActivity.class);
            startActivity(intent);
            finish();
        } else {
            new AlertDialog.Builder(AgeActivity.this)
                    .setTitle("錯誤")
                    .setMessage("請輸入資料, 謝謝!")
                    .setPositiveButton("OK", null)
                    .show();
        }
    }
}
