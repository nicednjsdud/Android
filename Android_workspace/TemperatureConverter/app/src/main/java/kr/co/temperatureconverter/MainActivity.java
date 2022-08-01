package kr.co.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.editText);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.dog);
        setTitle("온도변환 앱");
    }

    public void onClicked(View view){

    }
    public float convertCelsiusToFahrenheit(float celsius){

        return 0.0F;
    }
    public float convertFahrenheitToCelsius(float fahrenheit){

        return 0.0F;
    }
}