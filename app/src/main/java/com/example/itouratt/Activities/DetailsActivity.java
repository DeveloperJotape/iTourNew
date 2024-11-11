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

    private TextView txtTitle, txtScore, txtLocation, txtDescription;
    private DestinationsDomain item;
    private ImageView imgLoc;

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
        txtScore.setText(""+(int)item.getScore());
        txtDescription.setText(item.getDescription());

        int drawableResId = getResources().getIdentifier(item.getLocImage(), "drawable", getPackageName());
        Glide.with(this)
                .load(drawableResId)
                .into(imgLoc);

    }

    private void initView() {
        txtTitle = findViewById(R.id.txtTitle);
        txtLocation = findViewById(R.id.txtLocation);
        txtScore = findViewById(R.id.txtScore);
        txtDescription = findViewById(R.id.txtDescription);
        imgLoc = findViewById(R.id.imgLoc);
    }

    public void homeActivity(View view) {
        Intent in = new Intent(DetailsActivity.this, HomeActivity.class);
        startActivity(in);
    }

    public void appointmentActivity(View view) {
        Intent in = new Intent(DetailsActivity.this, AppointmentActivity.class);
        startActivity(in);
    }

}
