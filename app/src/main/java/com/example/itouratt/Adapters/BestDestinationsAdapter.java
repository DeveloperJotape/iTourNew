package com.example.itouratt.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.itouratt.Activities.DetailsActivity;
import com.example.itouratt.Domains.DestinationsDomain;
import com.example.itouratt.R;

import java.util.ArrayList;

public class BestDestinationsAdapter extends RecyclerView.Adapter<BestDestinationsAdapter.ViewHolder> {
    ArrayList<DestinationsDomain> items;

    public BestDestinationsAdapter(ArrayList<DestinationsDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public BestDestinationsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_best_destinations, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BestDestinationsAdapter.ViewHolder holder, int position) {
        holder.txtTitle.setText(items.get(position).getTitle());
        holder.txtLocation.setText(items.get(position).getLocation());
        holder.txtScore.setText(""+items.get(position).getScore());

        int drawableResId = holder.itemView.getResources().
                getIdentifier(items.get(position).getLocImage(), "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResId)
                .transform(new CenterCrop(), new GranularRoundedCorners(40,40,40,40))
                .into(holder.imgCard);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
            intent.putExtra("object", items.get(position));
            holder.itemView.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle, txtLocation, txtScore;
        ImageView imgCard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.cardTitle);
            txtLocation = itemView.findViewById(R.id.cardTxtLocation);
            txtScore = itemView.findViewById(R.id.cardScore);
            imgCard = itemView.findViewById(R.id.cardImg);
        }
    }
}
