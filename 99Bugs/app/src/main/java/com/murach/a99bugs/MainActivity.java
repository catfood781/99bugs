package com.murach.a99bugs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button takeOneDown;
    private Button takeTwoDown;
    private TextView bugsCounter;
    int bugs = 99;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        takeOneDown = (Button)findViewById(R.id.takeOneDownButton);
        takeTwoDown = (Button)findViewById(R.id.takeTwoDownButton);
        bugsCounter = (TextView)findViewById(R.id.numberTextView);

        takeOneDown.setOnClickListener(this);
        takeTwoDown.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        bugs = intent.getIntExtra("bugCount", 99);
        bugsCounter.setText(bugs + " bugs in the code.");
    }

    @Override
    public void onClick(View v) {

        Intent intent =
                new Intent(getApplicationContext(), SecondActivity.class);
        if (v.getId() == R.id.takeOneDownButton) {
            intent.putExtra("bugCount", bugs);
            intent.putExtra("removeBug", 1);
        }
        else if (v.getId() == R.id.takeTwoDownButton)
        {
            intent.putExtra("bugCount", bugs);
            intent.putExtra("removeBug", 2);
        }
        startActivityForResult(intent, 1);
    }
}
