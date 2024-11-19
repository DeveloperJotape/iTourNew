package com.example.itouratt.Activities;


import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itouratt.Adapters.BestDestinationsAdapter;
import com.example.itouratt.Domains.DestinationsDomain;
import com.example.itouratt.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    public RecyclerView.Adapter adapterBestDestinations;
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
                4, 5000.0, "cristo_redentor"));
        itens.add(new DestinationsDomain("Torre Eiffel",
                "Paris", "França",
                "TEXTO TEXTO TEXTO TEXTO",
                3, 10000.0, "travel1"));
        itens.add(new DestinationsDomain("Coliseu",
                "Roma", "Itália",
                "TEXTO TEXTO TEXTO TEXTO",
                4, 10000.0, "travel2"));

        recyclerViewBestDestinations = findViewById(R.id.view_best_destination);
        recyclerViewBestDestinations.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterBestDestinations = new BestDestinationsAdapter(itens);
        recyclerViewBestDestinations.setAdapter(adapterBestDestinations);

    }

}
