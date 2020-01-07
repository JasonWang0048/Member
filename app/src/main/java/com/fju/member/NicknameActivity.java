package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NicknameActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edNickname;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        edNickname = findViewById(R.id.nickname);
        findViewById(R.id.next1).setOnClickListener(this);
        pref = getSharedPreferences("exam", MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        nameOK();
    }

    public void nameOK() {
        pref.edit()
                .putString("NICKNAME", edNickname.getText().toString())
                .commit();
        if (!edNickname.getText().toString().equals("")) {
            Intent intent = new Intent();
            intent.setClass(NicknameActivity.this, AgeActivity.class);
            startActivity(intent);
            finish();
        } else {
            new AlertDialog.Builder(NicknameActivity.this)
                    .setTitle("錯誤")
                    .setMessage("請輸入資料, 謝謝!")
                    .setPositiveButton("OK", null)
                    .show();
        }
    }
}
