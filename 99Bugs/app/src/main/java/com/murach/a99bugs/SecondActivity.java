package com.murach.a99bugs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity implements View.OnClickListener {

    private int removeBug;
    private int bugCount;
    private Button PatchItAroundButton;
    private TextView littleBugsInTheCodeTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        PatchItAroundButton = findViewById(R.id.PatchItAroundButton);
        littleBugsInTheCodeTextView = findViewById(R.id.littleBugsInTheCodeTextView);
        PatchItAroundButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        bugCount = intent.getIntExtra("bugCount", 99);
        removeBug = intent.getIntExtra("removeBug", 0);
        littleBugsInTheCodeTextView.setText("There are " + bugCount + " bugs left in the code.");
    }


    @Override
    public void onClick(View v) {
        Intent intent =
                new Intent(getApplicationContext(), MainActivity.class);
        if (v.getId() == R.id.PatchItAroundButton)
        {
            bugCount -= removeBug;
            intent.putExtra("bugCount", bugCount);
        }
        startActivityForResult(intent, 1);
    }
}
