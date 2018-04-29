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
                calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                NumberPickerDialog dialog=new NumberPickerDialog(MainActivity.this, year , year + 10, new NumberPickerDialog.NumberPickerCallBack() {
                    @Override
                    public void onSelectingValue(int value) {
                        Toast.makeText(MainActivity.this, "Selected Year "+String.valueOf(value), Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

                /*NumberPickerDialog dialog=new NumberPickerDialog(MainActivity.this, -50, 50, new NumberPickerDialog.NumberPickerCallBack() {
                    @Override
                    public void onSelectingValue(int value) {
                        Toast.makeText(MainActivity.this, "Selected "+String.valueOf(value), Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();*/

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
