package ca.lestienne.androidlab.currencyexchangecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ExchangeActivity extends AppCompatActivity {

    public static final String USD_ID = "$ US Dollar";
    public static final String EUR_ID = "€ Euro";
    public static final String CNY_ID = "¥ Chinese Yen";

    public static final double USD_RATE = 0.74;
    public static final double EUR_RATE = 0.69;
    public static final double CNY_RATE = 5.11;

    private double exRate;
    private EditText cdnInput;
    private EditText localCurrencyField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);

        Intent intent = getIntent();
        String toExchange = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView rateDisplay = (TextView) findViewById(R.id.exchangeRate);
        rateDisplay.setText(toExchange);

        switch(toExchange){
            case USD_ID: exRate = USD_RATE; break;
            case EUR_ID: exRate = EUR_RATE; break;
            case CNY_ID: exRate = CNY_RATE; break;
            default: exRate = 1; break;
        }

        cdnInput = (EditText) findViewById(R.id.cdnInput);
        localCurrencyField = (EditText) findViewById(R.id.localCurrency);
    }

    public void convertCurrency(View view){
        double amountToConvert = Double.parseDouble(cdnInput.getText().toString());
        double amountConverted = amountToConvert * exRate;
        localCurrencyField.setText(String.valueOf(amountConverted));
    }
}
