package com.andreslim.myapplication2;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView web;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button) findViewById(R.id.vibrar);

        final Vibrator vibrar = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);       //activa el servicio para vibrar

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long[] pattern = {0, 200, 50, 100, 50, 100, 50, 200, 100, 200, 300, 200, 100, 200};          //tiempo de vibracion y Silencio
                vibrar.vibrate(pattern, -1);                 //poner 0 para repetir infinitamente, poner -1 para repetir solo una vez

            }
        });

        web = (WebView) findViewById(R.id.web);

        web.getSettings().setJavaScriptEnabled(true);                       //Habilita JavaScrip
        web.getSettings().setBuiltInZoomControls(true);                     //Habilita controles de zoom


        web.loadUrl("http://google.com");

        web.setWebViewClient(new WebViewClient(){


            public boolean shouldOverrideUrlloading(WebView view, String url){           //Forza a quedarse en el cliente dentro de la App

                return false;
            }

        }



        );

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.Op1:
                Toast.makeText(getApplicationContext(),"Opcion 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Op2:
                Toast.makeText(getApplicationContext(), "Opcion 2", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
