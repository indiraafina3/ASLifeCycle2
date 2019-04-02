package com.codepolitan.myapplicationviewpager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepolitan.myapplicationviewpager.R;

import org.w3c.dom.Text;

public class ArtikelViewHolder extends RecyclerView.ViewHolder {
    ImageView tvSampul;
    TextView tvJudul, tvNamaPenulis;

    public ArtikelViewHolder(View itemView) {
        super(itemView);
    tvSampul = itemView.findViewById(R.id.Sampul);
    tvJudul = itemView.findViewById(R.id.tv_judul);
    tvNamaPenulis = itemView.findViewById(R.id.tvpenulis);
    }
}
