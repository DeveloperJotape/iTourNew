package com.example.itouratt.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.itouratt.Domains.DestinationsDomain;
import com.example.itouratt.R;

public class DetailsActivity extends AppCompatActivity {

    private TextView txtTitle, txtLocation, txtScore,txtDescription;
    private DestinationsDomain item;
    private ImageView imgDestiny, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);

        initView();
        setVariable();
    }

    private void setVariable() {
        item = (DestinationsDomain) getIntent().getSerializableExtra("object");

        txtTitle.setText(item.getTitle());
        txtLocation.setText(item.getLocation());
        txtScore.setText("" +(int)item.getScore());
        txtDescription.setText(item.getDescription());

        int drawableResId = getResources().getIdentifier(item.getLocImage(), "drawable", getPackageName());
        Glide.with(this)
                .load(drawableResId)
                .into(imgDestiny);

        btnBack.setOnClickListener(v -> finish());
    }

    private void initView() {
        txtTitle = findViewById(R.id.txtTitle);
        txtLocation = findViewById(R.id.txtLocation);
        txtScore = findViewById(R.id.txtScore);
        txtDescription = findViewById(R.id.txtDescription);
        imgDestiny = findViewById(R.id.imgDestiny);
        btnBack.findViewById(R.id.btnBack);

    }

}
