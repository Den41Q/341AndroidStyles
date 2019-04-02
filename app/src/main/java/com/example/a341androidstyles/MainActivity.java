package com.example.a341androidstyles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner language;
    private Button btnChange;
    private Spinner theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        btnChange = findViewById(R.id.btn_change);
        language = findViewById(R.id.spinner);
        theme = findViewById(R.id.spinner_color);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String spinner = language.getSelectedItem().toString();

                if ("Русский".equalsIgnoreCase(spinner) | "Russian".equalsIgnoreCase(spinner)) {
                    Locale locale = new Locale("ru");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config,
                            getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                } else if ("Английский".equalsIgnoreCase(spinner) |
                        "English".equalsIgnoreCase(spinner)) {
                    Locale locale = new Locale("en");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config,
                            getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                }
            }
        });
    }

    public void changeTheme(View view) {
        String spinTheme = theme.getSelectedItem().toString();

        switch (spinTheme) {
            case "Черный":
                Utils.changeToTheme(this, Utils.THEME_BLACK);
                break;
            case "Зеленый":
                Utils.changeToTheme(this, Utils.THEME_GREEN);
                break;
            case "Синий":
                Utils.changeToTheme(this, Utils.THEME_BLUE);
                break;
        }
    }
}