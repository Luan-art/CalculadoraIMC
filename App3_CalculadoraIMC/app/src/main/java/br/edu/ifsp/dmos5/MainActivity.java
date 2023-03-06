package br.edu.ifsp.dmos5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText weightEditText;
    private EditText heightEditText;
    private TextView outputTextView;
    private Button calculeteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        weightEditText = findViewById(R.id.edittext_weight);
        heightEditText = findViewById(R.id.edittext_height);
        outputTextView = findViewById(R.id.text_view_output);
        calculeteButton = findViewById(R.id.btn_calculate);
        calculeteButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view == calculeteButton){
            process();
        }
    }

    private void process(){
        double weigth = getDouble(weightEditText);
        double heigth = getDouble(heightEditText);
        double imc;

        if(weigth != 0 && heigth != 0){
            imc=weigth/(heigth * heigth);
            outputTextView.setText(String.format("%s %.2f", "IMC", imc));
        }
    }

    private double getDouble(EditText edit){
        double value;
        try{
            value = Double.valueOf(edit.getText().toString());
        } catch (NumberFormatException nfe){
            Toast.makeText(this, R.string.numeber_error_mensagem, Toast.LENGTH_SHORT).show();
            value = 0;
        }
        return value;
    }
}