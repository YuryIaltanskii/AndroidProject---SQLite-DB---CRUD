package com.example.alumno.iialtanskii_1_parcial;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SelectActivity extends AppCompatActivity {

    Button email_button;
    Button db_button;
    TextView sharepreflogin;
    public static final String w = "Welcome";
    EditText ed1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        sharepreflogin = (TextView) findViewById(R.id.sharepreflogin);

        SharedPreferences prefs = getSharedPreferences("sharedPref",Context.MODE_PRIVATE);
        String user = prefs.getString("user", "");
        sharepreflogin.setText("Welcome, " + user);

        Toolbar myToolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);

        email_button = (Button)findViewById(R.id.Email_button);
        db_button = (Button) findViewById(R.id.DB_Button);

        email_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent().setClass(SelectActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });

        db_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent dbIntent = new Intent().setClass(SelectActivity.this, CountryListActivity.class);
                startActivity(dbIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_about:
                Intent aboutIntent = new Intent().setClass(SelectActivity.this, About.class);
                startActivity(aboutIntent);
                return true;
            case R.id.action_options:
                Intent dbIntent = new Intent().setClass(SelectActivity.this, Options.class);
                startActivity(dbIntent);
            case R.id.action_back:
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
