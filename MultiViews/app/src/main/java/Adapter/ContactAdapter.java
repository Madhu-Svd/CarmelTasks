package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carmel.multiviews.R;

import java.util.ArrayList;

import Model.Contact_list;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private ArrayList<Contact_list> contactsList;
    private Context mContext;
    private ContactAdapter(Context context, ArrayList<Contact_list> contactList){
        this.contactsList=contactList;
        this.mContext=context;

    }
    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case Contact_list.TEXT_TYPE:
                View view=layoutInflater.inflate(R.layout.list_item1,parent,false);
                return new ViewHolder1(view);

            case Contact_list.TEXT_TYPE:
                View view=layoutInflater.inflate(R.layout.list_item2,parent,false);
                return new ViewHolder2(view);

        }
        View view=layoutInflater.inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private class ViewHolder2 extends ViewHolder {
        public ViewHolder2(View view) {
            super(view);
        }
    }

    private class ViewHolder1 extends ViewHolder {
        public ViewHolder1(View view) {
            super(view);
        }
    }
}
