package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText number1EditText;
    private EditText number2EditText;
    private TextView resultTextView;
    private RadioButton addRadioButton;
    private RadioButton subtractRadioButton;
    private RadioButton multiplyRadioButton;
    private RadioButton divideRadioButton;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1EditText = findViewById(R.id.number1EditText);
        number2EditText = findViewById(R.id.number2EditText);
        resultTextView = findViewById(R.id.resultTextView);
        addRadioButton = findViewById(R.id.addRadioButton);
        subtractRadioButton = findViewById(R.id.subtractRadioButton);
        multiplyRadioButton = findViewById(R.id.multiplyRadioButton);
        divideRadioButton = findViewById(R.id.divideRadioButton);

        // Set click listener for calculate button (replace with your button ID)
        findViewById(R.id.calculateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });

    }

    private void calculate() {
        String number1String = number1EditText.getText().toString();
        String number2String = number2EditText.getText().toString();

        // Validate input
        if (number1String.isEmpty() || number2String.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double number1 = Double.parseDouble(number1String);
        double number2 = Double.parseDouble(number2String);

        double result = 0;
        String operation = "";

        if (addRadioButton.isChecked()) {
            operation = "+";
            result = number1 + number2;
        } else if (subtractRadioButton.isChecked()) {
            operation = "-";
            result = number1 - number2;
        } else if (multiplyRadioButton.isChecked()) {
            operation = "*";
            result = number1 * number2;
        } else if (divideRadioButton.isChecked()) {
            if (number2 == 0) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                return;
            }
            operation = "/";
            result = number1 / number2;
        }

        resultTextView.setText(String.format("%.2f %s %.2f = %.2f", number1, operation, number2, result));

    }
}