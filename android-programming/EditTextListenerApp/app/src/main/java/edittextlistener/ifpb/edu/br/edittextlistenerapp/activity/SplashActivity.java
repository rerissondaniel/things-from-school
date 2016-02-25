package edittextlistener.ifpb.edu.br.edittextlistenerapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import edittextlistener.ifpb.edu.br.edittextlistenerapp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                finish();

                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, BuscarNomeActivity.class);
                startActivity(intent);
            }
        }, 6000);
    }

}
