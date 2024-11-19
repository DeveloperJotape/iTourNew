package com.example.itouratt.Activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.itouratt.Domains.DestinationsDomain;
import com.example.itouratt.R;

public class TicketsActivity extends AppCompatActivity {

    private DetailsActivity details;
    private DestinationsDomain destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tickets);

        /*getIntentExtra();*/
        setVariable();
    }

    private void setVariable() {

    }

    /*private void getIntentExtra() {
        destination = getIntent().getSerializableExtra();
    }*/

}
