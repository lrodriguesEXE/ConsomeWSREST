package br.com.asantana.consomewsrest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class LivroAdapter extends RecyclerView.Adapter <LivroViewHolder>{
    private Context context;
    private List <Livro> livros;
    public LivroAdapter(Context context, List<Livro> livros) {
        this.context = context;
        this.livros = livros;
    }
    public LivroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View raiz = inflater.inflate(
                R.layout.list_item,
                parent,
                false
        );
        return new LivroViewHolder(raiz);
    }
    public void onBindViewHolder(@NonNull LivroViewHolder holder, int position) {
        Livro livro = this.livros.get(position);
        holder.autorTextView.setText(livro.getAutor());
        holder.paginasTextView.setText(livro.getEdicao());
        holder.tituloTextView.setText(livro.getTitulo());
    }
    public int getItemCount() {
        return livros.size();
    }}
