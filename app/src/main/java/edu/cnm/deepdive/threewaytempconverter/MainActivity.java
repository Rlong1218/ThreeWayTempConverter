package edu.cnm.deepdive.threewaytempconverter;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  EditText celsius;
  EditText fahrenheit;
  EditText kelvin;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    getSupportActionBar().hide();

    celsius = (EditText) findViewById(R.id.celsius);
    fahrenheit = (EditText) findViewById(R.id.fahrenheit);
    kelvin = (EditText) findViewById(R.id.kelvin);

    celsius.addTextChangedListener(new TextWatcher() {

      public void afterTextChanged(Editable s) {
      }

      public void beforeTextChanged(CharSequence s, int start,
          int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (celsius.isFocused()) {
          fahrenheit.setText("");
          kelvin.setText("");
        }
        if (celsius.isFocused() && celsius.length() > 0) {
          if (((celsius.getText().toString().startsWith("-") || celsius.getText().toString()
              .startsWith(".")) && celsius.length() < 2) || celsius.getText().toString()
              .startsWith("-.") && celsius.length() < 3) {
            kelvin.setText("");
            fahrenheit.setText("");
          } else {
            kelvin.setText(String.valueOf(returnCelsiusToKelvin(s.toString())));
            fahrenheit.setText(String.valueOf(returnCelsiusToFahrenheit(s.toString())));
          }
        }
      }
    });

    fahrenheit.addTextChangedListener(new TextWatcher() {

      public void afterTextChanged(Editable s) {
      }

      public void beforeTextChanged(CharSequence s, int start,
          int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (fahrenheit.isFocused()) {
          kelvin.setText("");
          celsius.setText("");
        }
        if (fahrenheit.isFocused() && fahrenheit.length() > 0) {
          if (((fahrenheit.getText().toString().startsWith("-") || fahrenheit.getText().toString()
              .startsWith(".")) && fahrenheit.length() < 2) || fahrenheit.getText().toString()
              .startsWith("-.") && fahrenheit.length() < 3) {
            kelvin.setText("");
            celsius.setText("");
          } else {
            kelvin.setText(String.valueOf(returnFahrenheitToKelvin(s.toString())));
            celsius.setText(String.valueOf(returnFahrenheitToCelsius(s.toString())));
          }
        }
      }

    });

    kelvin.addTextChangedListener(new TextWatcher() {

      public void afterTextChanged(Editable s) {
      }

      public void beforeTextChanged(CharSequence s, int start,
          int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {

        if (kelvin.isFocused()) {
          fahrenheit.setText("");
          celsius.setText("");
        }
        if (kelvin.isFocused() && kelvin.length() > 0) {
          if ((kelvin.getText().toString().startsWith("-") || kelvin.getText().toString().startsWith("."))
              && kelvin.length() < 2) {
            fahrenheit.setText("");
            celsius.setText("");
          } else {
            fahrenheit.setText(String.valueOf(returnKelvinToFahrenheit(s.toString())));
            celsius.setText(String.valueOf(returnKelvinToCelsius(s.toString())));
          }
        }
      }

    });
  }

  public double returnCelsiusToFahrenheit(String value) {
    double cel = Double.parseDouble(value);
    return (cel * 9 / 5) + 32;
  }

  public double returnCelsiusToKelvin(String value) {
    double cel = Double.parseDouble(value);
    return cel + 273.15;
  }

  public double returnFahrenheitToKelvin(String value) {
    double fah = Double.parseDouble(value);
    return (fah + 459.67) * 5 / 9;
  }

  public double returnFahrenheitToCelsius(String value) {
    double fah = Double.parseDouble(value);
    return (fah - 32) / ((double) 9 / 5);
  }

  public double returnKelvinToFahrenheit(String value) {
    double kel = Double.parseDouble(value);
    return (kel * 9 / 5f) - 459.67;
  }

  public double returnKelvinToCelsius(String value) {
    double cel = Double.parseDouble(value);
    return cel - 273.15;
  }
}