package com.carmel.guestjini.Support;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carmel.guestjini.R;

import java.util.ArrayList;

import Model.TicketsModel;


class ExploreTicketsAdapter extends RecyclerView.Adapter<ExploreTicketsAdapter.ViewHolder> {
    private Context context;
    ArrayList<TicketsModel> ticketsModelArrayList;
    public ExploreTicketsAdapter(Context context, ArrayList<TicketsModel> ticketsModelsList) {
        this.context=context;
        this.ticketsModelArrayList=ticketsModelsList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.explore_list,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreTicketsAdapter.ViewHolder holder, int position) {
        final TicketsModel ticketsModel=this.ticketsModelArrayList.get(position);
        holder.ticketsName.setText(String.valueOf(ticketsModel.getTicketsName()));
        holder.ticketsDate.setText(String.valueOf(ticketsModel.getTicketsDate()));
        holder.ticketsAuthorName.setText(String.valueOf(ticketsModel.getTicketsAuthorName()));
        holder.ticketsDescription.setText(String.valueOf(ticketsModel.getTicketsDescription()));
    }


    @Override
    public int getItemCount() {
        return ticketsModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profilePicture,navigationIcon;
        TextView ticketsName,ticketsDate,ticketsAuthorName,ticketsDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profilePicture=itemView.findViewById(R.id.profilePicture);
            navigationIcon=itemView.findViewById(R.id.navigationIcon);
            ticketsName=itemView.findViewById(R.id.ticketName);
            ticketsDate=itemView.findViewById(R.id.ticketDate);
            ticketsAuthorName=itemView.findViewById(R.id.ticketAuthorName);
            ticketsDescription=itemView.findViewById(R.id.ticketDescription);

            profilePicture.setImageResource(R.drawable.profile_image);
            navigationIcon.setImageResource(R.drawable.navigation_icon_xhdpi);
        }
    }
}
