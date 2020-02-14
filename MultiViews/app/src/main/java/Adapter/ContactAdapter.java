package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carmel.multiviews.R;

import java.util.ArrayList;

import Model.Contact_list;

import static Model.Contact_list.ONE_TYPE;
import static Model.Contact_list.TWO_TYPE;




public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
private ArrayList<Contact_list> contact_lists;
    public ContactAdapter(ArrayList<Contact_list> contact_lists) {
        this.contact_lists=contact_lists;

    }
        @Override
    public int getItemViewType(int position) {
        Contact_list contact_list=contact_lists.get(position);
        if(contact_list!=null){
           return contact_list.getViewType();
        }
        return 0;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view;
        switch (viewType){
            case ONE_TYPE:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
                return new OneViewHolder(view);

            case TWO_TYPE:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item1,parent,false);
                return new TwoViewHolder(view);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Contact_list contact_list=contact_lists.get(position);
        switch (contact_list.getViewType()){
            case ONE_TYPE:
                ((OneViewHolder)holder).name.setText(contact_list.getName());
                break;
            case TWO_TYPE:
                ((TwoViewHolder)holder).name.setText(contact_list.getName());
            break;
        }

    }


    @Override
    public int getItemCount() {
        return contact_lists.size();
    }

    class OneViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.txt_name);
        }
    }
    class TwoViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.txt_name);
        }
    }
}


