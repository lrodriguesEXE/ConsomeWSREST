package br.com.asantana.consomewsrest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EdicaoActivity extends AppCompatActivity {
    EditText titulo, autor, paginas, edicao;
    Button salvarLivro;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao);

        titulo = findViewById(R.id.tituloEditText);
        autor = findViewById(R.id.autorEditText);
        paginas = findViewById(R.id.paginasEditText);
        edicao = findViewById(R.id.edicaoEditText);
        salvarLivro = findViewById(R.id.salvaLivroButton);

        requestQueue = Volley.newRequestQueue(this);

        salvarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarLivros();
            }
        });
    }

    public String montaUrl(String... args) {
        StringBuilder sb = new StringBuilder();
        for (String s : args) {
            sb.append(s);
        }
        return sb.toString();
    }


    public void salvarLivros() {
        JSONObject livroData = new JSONObject();
        try {
            livroData.put("titulo", titulo.getText().toString());
            livroData.put("autor", autor.getText().toString());
            livroData.put("numeroPaginas", paginas.getText());
            livroData.put("edicao", edicao.getText());
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "" + e.toString(), Toast.LENGTH_SHORT).show();
        }

        String url = montaUrl(
                getString(R.string.host_address),
                getString(R.string.host_port),
                getString(R.string.endpoint_base),
                getString(R.string.endpoint_salvar)
        );
        requestQueue.add(new JsonObjectRequest(
                Request.Method.POST,
                url, livroData,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(EdicaoActivity.this, "Livro salvo com sucesso!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(EdicaoActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }));
    }
}
