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

import Model.CommunityGroupsListModel;


public class CommunityGroupsAdapter extends RecyclerView.Adapter<CommunityGroupsAdapter.ViewHolder> {
    ArrayList<CommunityGroupsListModel> communityGroupsList;
    Context context;
    public CommunityGroupsAdapter(Context context, ArrayList<CommunityGroupsListModel> communityGroupsList) {
        this.context=context;
        this.communityGroupsList=communityGroupsList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.community_groups_container,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CommunityGroupsListModel communityGroupsListModel=this.communityGroupsList.get(position);
//        holder.addNotificationIndicator.setText(String.valueOf(communityGroupsListModel.getAddNotificationIndicator()));
        holder.addCommunityGroupTitle.setText(String.valueOf(communityGroupsListModel.getAddCommunityGroupTitle()));
        holder.addCommunityGroupAdminName.setText(String.valueOf(communityGroupsListModel.getAddCommunityGroupAdminName()));
        holder.addCommunityGroupDescription.setText(String.valueOf(communityGroupsListModel.getAddCommunityGroupDescription()));
        holder.addCommunityGroupCreationDateAndTime.setText(String.valueOf(communityGroupsListModel.getAddCommunityGroupCreationDateAndTime()));
        holder.addCommunityGroupInformationMessage.setText(String.valueOf(communityGroupsListModel.getAddCommunityGroupInformationMessage()));

    }

    @Override
    public int getItemCount() {
        return communityGroupsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView addCommunityGroupTitle,addCommunityGroupAdminName,addCommunityGroupDescription;
     TextView addCommunityGroupCreationDateAndTime,addCommunityGroupInformationMessage;
        ImageView addInformationIcon,addAdminProfileIcon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            addNotificationIndicator=itemView.findViewById(R.id.communityGroupNotificationIndicator);
            addCommunityGroupTitle=itemView.findViewById(R.id.groupsName);
            addCommunityGroupAdminName=itemView.findViewById(R.id.groupAdmin);
            addCommunityGroupCreationDateAndTime=itemView.findViewById(R.id.groupCreationDateAndTime);
            addCommunityGroupDescription=itemView.findViewById(R.id.groupsDescription);
            addCommunityGroupInformationMessage=itemView.findViewById(R.id.informationMessage);
            addAdminProfileIcon=itemView.findViewById(R.id.communityGroupsProfileIcon);
            addInformationIcon=itemView.findViewById(R.id.informationIcon);
            addAdminProfileIcon.setImageResource(R.drawable.profile_image);
            addInformationIcon.setImageResource(R.drawable.information_icon);

        }
    }
}
