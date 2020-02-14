package Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.carmel.guestjini.R;

import java.util.ArrayList;

import Model.MyTicketsModel;

import static Model.MyTicketsModel.ONE_TYPE;
import static Model.MyTicketsModel.TWO_TYPE;

public class TicketAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
private ArrayList<MyTicketsModel> myTicketsModels;
private Context context;

    public TicketAdapter(ArrayList<MyTicketsModel> myTicketsModelsList) {
        this.myTicketsModels = myTicketsModelsList;
    }
    @Override
    public int getItemViewType(int position) {
        MyTicketsModel myTicketsModel=myTicketsModels.get(position);
        if(myTicketsModel!=null){
            return myTicketsModel.getViewType();
        }
        return 0;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case ONE_TYPE:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_tickets_list,parent,false);
                return new OneViewHolder(view);

            case TWO_TYPE:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.draft_list,parent,false);
                return new TwoViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyTicketsModel myTicketsModel =myTicketsModels.get(position);
       switch (myTicketsModel.getViewType()){
           case ONE_TYPE:
               ((OneViewHolder)holder).ticketsStatus.setText(myTicketsModel.getTicketsStatus());
               ((OneViewHolder)holder).ticketsDate.setText(myTicketsModel.getTicketsDateAndTime());
               ((OneViewHolder)holder).ticketsName.setText(myTicketsModel.getTicketsName());
               ((OneViewHolder)holder).ticketsNo.setText(myTicketsModel.getTicketsNo());
               ((OneViewHolder)holder).ticketsValue.setText(myTicketsModel.getTicketsValue());
               ((OneViewHolder)holder).clock.setText(myTicketsModel.getClock());
               ((OneViewHolder)holder).ticketsTime.setText(myTicketsModel.getTicketsTime());
                break;
           case TWO_TYPE:
               ((TwoViewHolder)holder).ticketsStatus.setText(myTicketsModel.getTicketsStatus());
               ((TwoViewHolder)holder).ticketsDate.setText(myTicketsModel.getTicketsDateAndTime());
               ((TwoViewHolder)holder).ticketsName.setText(myTicketsModel.getTicketsName());
               ((TwoViewHolder)holder).ticketDelete.setText(myTicketsModel.getDelete());

                break;
       }
    }

    @Override
    public int getItemCount() {
        return myTicketsModels.size();
    }

    class OneViewHolder extends RecyclerView.ViewHolder {
        TextView ticketsStatus,ticketsDate,ticketsName,ticketsNo,ticketsValue,clock,ticketsTime;
        CardView cardView;
        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            ticketsStatus=itemView.findViewById(R.id.ticketsStatus);
            ticketsDate=itemView.findViewById(R.id.tickestsDateAndTime);
            ticketsName=itemView.findViewById(R.id.ticketsName);
            ticketsNo=itemView.findViewById(R.id.ticketsNo);
            ticketsValue=itemView.findViewById(R.id.ticketsValue);
            clock=itemView.findViewById(R.id.clock);
            ticketsTime=itemView.findViewById(R.id.clockTime);
//            cardView=itemView.findViewById(R.id.OpenCardView);
        }
    }
    class TwoViewHolder extends RecyclerView.ViewHolder {
        TextView ticketsStatus,ticketsDate,ticketsName,ticketDelete;
//        CardView cardView;
        ImageView deleteIcon;
        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            ticketsStatus=itemView.findViewById(R.id.ticketsStatus);
            ticketsDate=itemView.findViewById(R.id.tickestsDateAndTime);
            ticketsName=itemView.findViewById(R.id.ticketsName);
//            cardView=itemView.findViewById(R.id.OpenCardView);
            ticketDelete=itemView.findViewById(R.id.deleteText);
            deleteIcon=itemView.findViewById(R.id.deleteIcon);
        }
    }
}
