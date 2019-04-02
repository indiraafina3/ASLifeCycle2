package com.codepolitan.myapplicationviewpager.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepolitan.myapplicationviewpager.DetailActivity;
import com.codepolitan.myapplicationviewpager.MainActivity;
import com.codepolitan.myapplicationviewpager.artikel.Artikel;
import com.codepolitan.myapplicationviewpager.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<ArtikelViewHolder> {
    //deklarasi dua atribut/variabel/properti
    List<Artikel> KumpulanArtikel;
    Context context;
    //constraktor inisialisasi atribut
    public MyRecycleViewAdapter(List<Artikel> kumpulanArtikel, Context context) {
        KumpulanArtikel = kumpulanArtikel;
        this.context = context;
    }

    @NonNull
    @Override
    public ArtikelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ArtikelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtikelViewHolder holder, int position) {
        final Artikel artikel = KumpulanArtikel.get(position);
        holder.tvJudul.setText(artikel.getTitle());
        holder.tvNamaPenulis.setText(artikel.getAuthor_name());
        Picasso.get().load(artikel.getThumbnail()).into(holder.tvSampul);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindahIntent = new Intent(context, DetailActivity.class);
                pindahIntent.putExtra("ARTIKEL",artikel);
                //pindahIntent.putExtra("title", artikel.getTitle());
               // pindahIntent.putExtra("link", artikel.getLink());
                context.startActivity(pindahIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return KumpulanArtikel.size();
    }
}
