package com.example.alumno.iialtanskii_1_parcial;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button b1;
    EditText ed1,ed2;
    public static final String user = "userKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar myToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        b1 = (Button)findViewById(R.id.login);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, SelectActivity.class);
                Bundle b = new Bundle();
                b.putString("user", ed1.getText().toString());
                b.putString("password", ed2.getText().toString());
                intent.putExtras(b);
                if(b.getString("user").toString().equals(b.getString("password").toString()) && !b.getString("user").toString().isEmpty() && !b.getString("password").toString().isEmpty()) {
                    SharedPreferences sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("user", ed1.getText().toString());
                    editor.commit();

                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Welcome " + b.getString("user").toString(),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}