package com.iaguilarmartin.madridguide.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.iaguilarmartin.madridguide.R;
import com.iaguilarmartin.madridguide.navigator.Navigator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button_activity_main_open_shops)
    Button openShopsButton;

    @BindView(R.id.button_activity_main_open_activities)
    Button openActivitiesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.setDebug(true);
        ButterKnife.bind(this);

        setupButton();
    }

    private void setupButton() {
        this.openShopsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigator.navigateFromMainActivityToShopsActivity(MainActivity.this);
            }
        });

        this.openActivitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigator.navigateFromMainActivityToActivitiesActivity(MainActivity.this);
            }
        });
    }
}
