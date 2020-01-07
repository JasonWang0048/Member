package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText edOp1;
    private EditText edOp2;
    private EditText edOp3;
    private SharedPreferences pref;
    //clone

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edOp1 = findViewById(R.id.output1);
        edOp2 = findViewById(R.id.output2);
        edOp3 = findViewById(R.id.output3);
        pref = getSharedPreferences("exam", MODE_PRIVATE);
        Log.d(TAG, "" + pref.contains("exam"));
        if (!pref.contains("NICKNAME") && !pref.contains("AGE") && !pref.contains("GENDER")) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, NicknameActivity.class);
            startActivity(intent);
        }
    }
}
