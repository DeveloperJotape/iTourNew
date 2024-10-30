package com.example.itouratt.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itouratt.Adapters.BestDestinationsAdapter;
import com.example.itouratt.Domains.DestinationsDomain;
import com.example.itouratt.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    public RecyclerView.Adapter adapterBestDestinarions;
    private RecyclerView recyclerViewBestDestinations;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initRecyclerView();
    }

    private void initRecyclerView() {

        ArrayList<DestinationsDomain> itens = new ArrayList<>();
        itens.add(new DestinationsDomain("Cristo Redentor",
                "Rio de Janeiro", "Brasil",
                "Imagine-se mergulhando nas famosas praias de Copacabana e Ipanema, explorando a rica cultura local e admirando paisagens deslumbrantes – tudo isso está ao seu alcance!",
                4.0, 5000.0, "cristo_redentor"));
        itens.add(new DestinationsDomain("Torre Eiffel",
                "Paris", "França",
                "TEXTO TEXTO TEXTO TEXTO",
                3.0, 10000.0, "travel1"));
        itens.add(new DestinationsDomain("Coliseu",
                "Roma", "Itália",
                "TEXTO TEXTO TEXTO TEXTO",
                4.5, 10000.0, "travel2"));

        recyclerViewBestDestinations = findViewById(R.id.view_best_destination);
        recyclerViewBestDestinations.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterBestDestinarions = new BestDestinationsAdapter(itens);
        recyclerViewBestDestinations.setAdapter(adapterBestDestinarions);

    }

    public void detailsActivity(View view) {
        Intent in = new Intent(HomeActivity.this, DetailsActivity.class);
        startActivity(in);
    }
}
