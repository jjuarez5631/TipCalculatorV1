package com.example.jjuarez.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    double mealTotal, tipTotal;

    float tipChoice;
    double tempTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText totalAmount =(EditText)findViewById(R.id.txtTotalAmount);
        final Spinner group = (Spinner)findViewById(R.id.txtGroup);
        Button charges = (Button) findViewById(R.id.btnCharge);
            charges.setOnClickListener(new View.OnClickListener(){
                final TextView results = ((TextView)findViewById(R.id.txtResults));
                @Override
                public void onClick(View view) {
                    mealTotal = Double.parseDouble(totalAmount.getText().toString());
                    tipChoice = Integer.parseInt(group.getSelectedItem().toString());
                    tempTip = mealTotal * (tipChoice / 100);
                    tipTotal = mealTotal + tempTip;
                    DecimalFormat currency = new DecimalFormat("$###,###.##");
                    results.setText("Total Including Tip: " + currency.format(tipTotal));

                }
            });
    }
}
