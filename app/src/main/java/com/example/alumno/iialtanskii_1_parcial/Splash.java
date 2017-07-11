package com.example.alumno.iialtanskii_1_parcial;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.content.Intent;

import java.util.Timer;
import java.util.TimerTask;


public class Splash extends Activity {

    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
// Definimos la orientación de la SplashScreen como Portrait (vertical)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
// Escondemos el título de la app
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask()

        {
            @Override
            public void run()
            {
// Start the next activity
                Intent mainIntent = new Intent().setClass(Splash.this, LoginActivity.class);
                startActivity(mainIntent);
// Terminamos la activity para que el usuario no pueda volver para atrás con el botón de back
                finish();
            }

        };

// Simulamos con un timer un tiempo de espera definido en una constante al comienzo
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

}
