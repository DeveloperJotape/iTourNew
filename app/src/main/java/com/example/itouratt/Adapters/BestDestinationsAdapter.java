package com.example.itouratt.Adapters;

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
import com.example.itouratt.Domains.DestinationsDomain;
import com.example.itouratt.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BestDestinationsAdapter extends RecyclerView.Adapter<BestDestinationsAdapter.ViewHolder> {
    ArrayList<DestinationsDomain> itens;
    DecimalFormat formatter;

    public BestDestinationsAdapter(ArrayList<DestinationsDomain> itens) {
        this.itens = itens;
        formatter = new DecimalFormat("###,###,###,###");
    }

    @NonNull
    @Override
    public BestDestinationsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_best_destinations, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BestDestinationsAdapter.ViewHolder holder, int position) {
        holder.txtTitle.setText(itens.get(position).getTitle());
        holder.txtLocation.setText(itens.get(position).getLocation());
        holder.txtScore.setText(""+itens.get(position).getScore());

        int drawableResId = holder.itemView.getResources().
                getIdentifier(itens.get(position).getLocImage(), "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResId)
                .transform(new CenterCrop(), new GranularRoundedCorners(40,40,40,40))
                .into(holder.imgCard);

    }

    @Override
    public int getItemCount() {
        return itens.size();
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
