package manlidi.demo;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import manlidi.demo.databinding.ActivityCalculatorBinding;
import manlidi.demo.databinding.ActivityMainBinding;

public class Calculator extends AppCompatActivity {
    String oldnumber = "";
    String op = "";
    boolean isnewop = true;
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        ed1 = findViewById(R.id.editText);
    }

    public void numberEvent(View view) {
        if(isnewop)
            ed1.setText("");
        isnewop = false;
        String number = ed1.getText().toString();
        switch (view.getId()){
            case R.id.bu0:
                number += "0";
                break;
            case R.id.buun:
                number += "1";
                break;
            case R.id.budeux:
                number = "2";
                break;
            case R.id.butrois:
                number += "3";
                break;
            case R.id.buquatre:
                number += "4";
                break;
            case R.id.bucinq:
                number += "5";
                break;
            case R.id.busix:
                number += "6";
                break;
            case R.id.busept:
                number += "7";
                break;
            case R.id.buhuit:
                number += "8";
                break;
            case R.id.buneuf:
                number += "9";
                break;
            case R.id.buvirgule:
                number += ".";
                break;
            case R.id.buplusmoins:
                number = "-"+number;
                break;
        }
        ed1.setText(number);
    }

    public void operatorEvent(View view) {
        isnewop = true;
        oldnumber = ed1.getText().toString();
        switch (view.getId()){
            case R.id.budivision: op = "/";break;
            case R.id.bumultiplication: op = "*";break;
            case R.id.bumoins: op = "-";break;
            case R.id.buplus: op = "+";break;
        }
    }

    public void equalEvent(View view) {
        String newNumber = ed1.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldnumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldnumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldnumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldnumber) / Double.parseDouble(newNumber);
                break;
        }
        ed1.setText(result+"");
    }

    public void acEvent(View view) {
        ed1.setText("0");
        isnewop = true;
    }

    public void percentEvent(View view) {
        Double no = Double.parseDouble(ed1.getText().toString())/100;
        ed1.setText(no+"");
        isnewop = true;
    }
}