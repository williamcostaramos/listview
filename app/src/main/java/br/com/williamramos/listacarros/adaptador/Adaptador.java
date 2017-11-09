package br.com.williamramos.listacarros.adaptador;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.williamramos.listacarros.R;
import br.com.williamramos.listacarros.model.Carro;

/**
 * Created by WIlliam Ramos 26/10/17.
 */

public class Adaptador extends ArrayAdapter<Carro> {


    public Adaptador(ArrayList<Carro> listaCarros, Context context) {
        super(context, 0, listaCarros);
    }

    public View getView(int posicao, View reciclado, ViewGroup pai) {

        if (reciclado == null) {
            reciclado = LayoutInflater.from(getContext()).inflate(R.layout.modelar_carro, pai, false);


        }


        TextView nome = (TextView) reciclado.findViewById(R.id.carro_nome);
        ImageView img = (ImageView) reciclado.findViewById(R.id.carro_imagem);

        TextView desc = (TextView) reciclado.findViewById(R.id.carro_desc);
        TextView latitude = (TextView) reciclado.findViewById(R.id.carro_latitude);

        TextView longitude = (TextView) reciclado.findViewById(R.id.carro_longitude);


        Carro carro= getItem(posicao);

        nome.setText(carro.getNome());

        desc.setText(carro.getDesc());
        latitude.setText(carro.getLatitude());
        longitude.setText(carro.getLongitude());

        Bitmap bitmap= buscarImagen(carro.getUrlFoto());

        img.setImageBitmap(bitmap);


        return reciclado;
    }
    
    
    //// TODO: 26/10/17  implementar o metodo de buscar a imagem na net;

    public Bitmap buscarImagen(String url){

        return  null;
    }
}
