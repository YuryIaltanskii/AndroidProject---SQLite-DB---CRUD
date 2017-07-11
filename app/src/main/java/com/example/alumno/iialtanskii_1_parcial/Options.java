package com.example.alumno.iialtanskii_1_parcial;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v7.widget.Toolbar;

import static com.example.alumno.iialtanskii_1_parcial.R.xml.preferences;

public class Options extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(preferences);
    }
}