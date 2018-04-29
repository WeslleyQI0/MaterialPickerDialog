package com.example.weslley.materialpickerdialog;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Calendar;

import adil.dev.lib.materialnumberpicker.dialog.GenderPickerDialog;
import adil.dev.lib.materialnumberpicker.dialog.NumberPickerDialog;

public class MainActivity extends AppCompatActivity {

    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                calendar = Calendar.getInstance(); //Cria uma Instancia de Calendar
                int year = calendar.get(Calendar.YEAR); // Pega o ano atua e Adiciona a variavel "year"

                //Mostra o ano atual e mais dez anos a frente no DialogPicker
                NumberPickerDialog dialog=new NumberPickerDialog(MainActivity.this, year , year + 10, new NumberPickerDialog.NumberPickerCallBack() {
                    @Override
                    public void onSelectingValue(int value) {
                        Toast.makeText(MainActivity.this, "Selected Year "+String.valueOf(value), Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

                //Picker de Numeros
                /*NumberPickerDialog dialog=new NumberPickerDialog(MainActivity.this, -50, 50, new NumberPickerDialog.NumberPickerCallBack() {
                    @Override
                    public void onSelectingValue(int value) {
                        Toast.makeText(MainActivity.this, "Selected "+String.valueOf(value), Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();*/

                //Picker de Genero
                /*GenderPickerDialog dialog=new GenderPickerDialog(MainActivity.this);
                dialog.setOnSelectingGender(new GenderPickerDialog.OnGenderSelectListener() {
                    @Override
                    public void onSelectingGender(String value) {
                        Toast.makeText(MainActivity.this, "Selected "+value, Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();*/
            }
        });
    }
}
