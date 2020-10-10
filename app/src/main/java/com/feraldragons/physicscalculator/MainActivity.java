package com.feraldragons.physicscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mass;
    Button vi;
    Button vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mass = findViewById(R.id.btnMass);
        vi = findViewById(R.id.btnVelocity);
        vf = findViewById(R.id.btnVelocityFinal);

        mass.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MassActivity.class);
                startActivity(intent);
            }
        });
        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,VelocityActivity.class);
                startActivity(intent);
            }
        });
        vf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,VelocityFActivity.class);
                startActivity(intent);
            }
        });

    }
}