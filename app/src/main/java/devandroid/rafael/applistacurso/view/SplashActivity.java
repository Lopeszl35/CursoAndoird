package devandroid.rafael.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.rafael.applistacurso.R;

public class SplashActivity extends AppCompatActivity {

    //Por quanto tempo a tela sera mostrada ao usuário
    public static final int TIME_OUT_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(devandroid.rafael.applistacurso.R.layout.activity_splash);

        cumutarTelaSplash();


    }

    private void cumutarTelaSplash() {
        //Método para mudar de tela
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(telaPrincipal);
                finish();
            }
        }, TIME_OUT_SPLASH);


    }
}