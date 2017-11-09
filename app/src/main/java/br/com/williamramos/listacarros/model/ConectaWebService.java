package br.com.williamramos.listacarros.model;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by catolica2017 on 26/10/17.
 */

public class ConectaWebService extends AsyncTask<URL, Void, ArrayList> {


    //metodo que executa a Thread em segundo plano
    @Override
    protected ArrayList<Carro> doInBackground(URL... urls) {


        Gson gson = new Gson();

        ArrayList<Carro> listaCarros = new ArrayList<>();
        try {


            String teste = getHtmlPage(urls[0]);

            listaCarros = gson.fromJson(teste, new TypeToken<ArrayList<Carro>>() {
            }.getType());


        } catch (Exception e) {
            e.printStackTrace();

        }


        return null;
    }


    //Metodo executado apos a conclusao da Thread
    //codigo chamado na Thread Principal
    public void onPostExecute(ArrayList<Carro> carros) {


    }


    private String getHtmlPage(URL url) {
        StringBuilder content = new StringBuilder();
        BufferedReader in = null;

        try {
            in = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );

            String line;
            while ((line = in.readLine()) != null)
                content.append(line);

            in.close();

            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
