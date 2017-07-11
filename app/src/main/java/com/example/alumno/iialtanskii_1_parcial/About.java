package com.example.alumno.iialtanskii_1_parcial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class About extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar myToolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);
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
                Intent aboutIntent = new Intent().setClass(About.this, About.class);
                startActivity(aboutIntent);
                return true;
            case R.id.action_options:
                Intent dbIntent = new Intent().setClass(About.this, Options.class);
                startActivity(dbIntent);
            case R.id.action_back:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
