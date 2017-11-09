package br.com.williamramos.listacarros;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import java.net.URL;

import br.com.williamramos.listacarros.model.ConectaWebService;

public class ActivityLista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_carro);


        try {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE,}, 12);


            ConectaWebService webService = new ConectaWebService();

            webService.execute(new URL("http://www.livroandroid.com.br/livro/carros/v2/carros_classicos.json"));

        } catch (Exception e) {
            e.getMessage();

        }


    }
}
