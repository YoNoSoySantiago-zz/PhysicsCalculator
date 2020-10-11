package com.feraldragons.physicscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VelocityActivity extends AppCompatActivity {
    Button calculate;
    EditText result1;
    EditText result2;
    private Calculator calculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocity);
        result1 = findViewById(R.id.textResultIV1);
        result2 = findViewById(R.id.textResultIV2);
        calculate = findViewById(R.id.button);
        calculator = new Calculator();

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    EditText edit = findViewById(R.id.textMass1IV);
                    double mass1 = Double.parseDouble( edit.getText().toString());
                    edit = findViewById(R.id.textMass2IV);
                    double mass2 = Double.parseDouble(edit.getText().toString());
                    edit = findViewById(R.id.textFV1);
                    double vf1 = Double.parseDouble(edit.getText().toString());
                    edit = findViewById(R.id.textFV2);
                    double vf2 = Double.parseDouble(edit.getText().toString());
                    if(mass1 > 0 && mass2>0){
                        double result[] =  calculator.calculateFinalVelocities(mass1,mass2,vf1,vf2);
                        result1.setText(result[0]+"");
                        result2.setText(result[1]+"");
                    }else{
                        MainActivity main = new MainActivity();
                        showAlertMass();
                    }

                }catch (NumberFormatException e){
                   showAlertFormat();
                }
            }
        });

    }
    public void showAlertFormat(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(VelocityActivity.this);
        builder.setMessage("Nuestro fisico aun no sabe como calcular esto, con datos no numericos :(");
        builder.setTitle("Formato no Valido");
        builder.setCancelable(true);
        builder.setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert11 = builder.create();
        alert11.show();
    }
    public void showAlertMass(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(VelocityActivity.this);
        builder.setMessage("Nuestro físico aun no sabe como colisionar objetos sin masa o con masa negativa:(");
        builder.setTitle("Masa no valida");
        builder.setCancelable(true);
        builder.setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert11 = builder.create();
        alert11.show();
    }
}