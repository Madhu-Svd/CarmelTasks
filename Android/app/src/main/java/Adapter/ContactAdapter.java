package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carmel.materialactivity.R;

import java.util.ArrayList;

import Model.JsonModel;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private Context context;
    private ArrayList<JsonModel> jsonModels;

    public ContactAdapter(Context applicationContext, ArrayList<JsonModel> jsonModels) {
        this.jsonModels=jsonModels;
        this.context=applicationContext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_watch,parent,false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JsonModel jsonModel=jsonModels.get(position);
//        holder.name.setText(jsonModel.getName());
//        holder.price.setText(jsonModel.getPrice());
        holder.name.setText(String.valueOf(jsonModel.getName()));
        holder.price.setText(String.valueOf(jsonModel.getPrice()));

    }


    @Override
    public int getItemCount() {
        return jsonModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.watchnameTxt);
            price=itemView.findViewById(R.id.watchpriceTxt);
        }
    }
}
