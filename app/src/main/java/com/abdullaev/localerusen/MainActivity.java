package com.abdullaev.localerusen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.intellij.lang.annotations.Language;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button buttonLocal;
    Spinner spinnerLocal;
    TextView text;

    enum Language{
        ru, en
    }

    Language language = Language.en;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        view();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.lan));
        spinnerLocal.setAdapter(adapter);
        buttonLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale locale = new Locale(language.name());
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerLocal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        language = Language.ru;
                        break;
                    case 1:
                        language = Language.en;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void view() {
        buttonLocal = findViewById(R.id.button);
        spinnerLocal = findViewById(R.id.spinner);
        text = findViewById(R.id.textView);
    }
}