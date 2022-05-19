package com.example.t3_evaluacion.adapter;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.t3_evaluacion.R;
import com.example.t3_evaluacion.entidades.Animes;
import com.squareup.picasso.Picasso;

import java.util.List;


public class AnimeAdapter extends RecyclerView.Adapter <AnimeAdapter.ViewHolderAnimes> {

    List<Animes> animes;

    public AnimeAdapter(List<Animes> animes) {
        this.animes = animes;
    }

    @NonNull
    @Override
    public AnimeAdapter.ViewHolderAnimes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        return new ViewHolderAnimes(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAnimes vh, int position) {
        View view= vh.itemView;
        Animes anime = animes.get(position);
        ImageView tvImage = view.findViewById(R.id.tvImag);
        TextView tvNombre = view.findViewById(R.id.tvNombre);
        TextView tvDescripcion = view.findViewById(R.id.tvDescripcion);
        Picasso.get().load(anime.imagen).into(tvImage);

        tvNombre.setText(anime.nombre);
        tvDescripcion.setText(anime.descripcion);
    }
    @Override
    public int getItemCount() {
        return animes.size();
    }


 class ViewHolderAnimes extends RecyclerView.ViewHolder {
     View view;
        public ViewHolderAnimes(@NonNull View itemView) {
            super(itemView);

            view = itemView.findViewById(R.id.btnFavorito);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   
                    Log.i("Nuevo","Cliene en el elemnto");
                }
            });
        }


 }

}
