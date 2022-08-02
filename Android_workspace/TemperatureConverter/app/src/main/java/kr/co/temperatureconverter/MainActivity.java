package kr.co.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

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

    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                RadioButton celsiusButtn = findViewById(R.id.rBtn1);
                RadioButton fahrenheitButton = findViewById(R.id.rBtn2);

                if (text.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                float inputValue = Float.parseFloat(text.getText().toString());
                if(celsiusButtn.isChecked()){
                    text.setText(String.valueOf(convertFahrenheitToCelsius(inputValue)));
                    celsiusButtn.setChecked(false);
                    fahrenheitButton.setChecked(true);
                }
                else{
                    text.setText(String.valueOf(convertCelsiusToFahrenheit(inputValue)));
                    fahrenheitButton.setChecked(false);
                    celsiusButtn.setChecked(true);
                }
                break;
        }
    }

    public float convertCelsiusToFahrenheit(float celsius) {

        return ((celsius * 9) / 5) + 32;
    }

    public float convertFahrenheitToCelsius(float fahrenheit) {

        return ((fahrenheit - 32) * 5 / 9);
    }
}