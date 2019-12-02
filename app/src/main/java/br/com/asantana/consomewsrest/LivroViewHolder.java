package br.com.asantana.consomewsrest;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class LivroViewHolder extends RecyclerView.ViewHolder{
    public TextView tituloTextView;
    public TextView autorTextView;
    public TextView paginasTextView;
    public LivroViewHolder (View raiz){
        super (raiz);
        this.tituloTextView = raiz.findViewById(R.id.tituloTextView);
        this.autorTextView = raiz.findViewById(R.id.autorTextView);
        this.paginasTextView = raiz.findViewById(R.id.paginasTextView);
    }
}
