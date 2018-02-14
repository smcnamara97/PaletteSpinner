package edu.temple.paletteactivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class PaletteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        Spinner color_spinner = (Spinner) findViewById(R.id.spinner);
        final View palette_layout = findViewById(R.id.activity_main_layout);
        String[] myColors = {"Green", "Blue", "Cyan", "Yellow", "Purple", "Grey", "Red"};
        colorAdapter<String> myAdapter = new colorAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,myColors);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        color_spinner.setAdapter(myAdapter);
        color_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                palette_layout.setBackgroundColor(Color.parseColor(((TextView) view).getText().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    class colorAdapter<S> extends ArrayAdapter{

        public colorAdapter(@NonNull Context context, int resource, String[] myColors) {
            super(context, resource,myColors);
        }
    }
}

