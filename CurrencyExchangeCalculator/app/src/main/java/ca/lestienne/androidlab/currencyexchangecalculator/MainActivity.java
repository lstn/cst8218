package ca.lestienne.androidlab.currencyexchangecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "ca.lestienne.androidlab.currencyexchangecalculator.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exchangeStart(View view){
        Intent intent = new Intent(this, ExchangeActivity.class);
        Spinner currencySpinner = (Spinner) findViewById(R.id.currencySpinner);
        String toExchange = currencySpinner.getSelectedItem().toString();
        intent.putExtra(EXTRA_MESSAGE, toExchange);
        startActivity(intent);
    }
}
