package Adapter;

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

import Model.InvitingMembersModel;
import Model.JoinedMemberModel;

public class JoinedMembersAdapter extends RecyclerView.Adapter<JoinedMembersAdapter.ViewHolder> {
    private Context context;
    private  ArrayList<JoinedMemberModel> joinedMembersList;
    public JoinedMembersAdapter(Context context, ArrayList<JoinedMemberModel> joinedMembersArrayList) {
        this.context=context;
        this.joinedMembersList=joinedMembersArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.joined_members_itemlist,parent,false);
        return new JoinedMembersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JoinedMemberModel joinedMembersModel=joinedMembersList.get(position);
        holder.joinedProfilePicture.setImageResource(joinedMembersModel.getJoinedProfilePicture());
        holder.joinedMemberName.setText(joinedMembersModel.getJoinedMembersName());
        holder.joinedDate.setText(joinedMembersModel.getJoinedDate());
    }

    @Override
    public int getItemCount() {
        return joinedMembersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView joinedProfilePicture;
        private TextView joinedMemberName,joinedDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            joinedProfilePicture=itemView.findViewById(R.id.joinedProfilePicture);
            joinedMemberName=itemView.findViewById(R.id.joinedMemberName);
            joinedDate=itemView.findViewById(R.id.joinedDate);
        }
    }
}
