package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carmel.guestjini.CommunityActivity;
import com.carmel.guestjini.GroupsActivity;
import com.carmel.guestjini.PeopleActivity;
import com.carmel.guestjini.ProfileActivity;
import com.carmel.guestjini.R;
import com.carmel.guestjini.SupportActivity;

import java.util.ArrayList;

import Model.CommunityLandingModel;

public class CommunityLandingAdapter extends RecyclerView.Adapter<CommunityLandingAdapter.ViewHolder> {
    private Context context;
    private ArrayList<CommunityLandingModel> communityLandingModels;
    private OnItemClickListener onItemClickListener;
    public CommunityLandingAdapter(ArrayList<CommunityLandingModel> communityLandingModelArrayList,OnItemClickListener onItemClickListener) {
        this.communityLandingModels=communityLandingModelArrayList;
        this.onItemClickListener=onItemClickListener;

    }

    public CommunityLandingAdapter(ArrayList<CommunityLandingModel> groupsLandingModelArrayList) {
        this.communityLandingModels=groupsLandingModelArrayList;

    }

    @NonNull
    @Override
    public CommunityLandingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.community_landing_list,parent,false);
        ViewHolder viewHolder=new ViewHolder(view,onItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityLandingAdapter.ViewHolder holder, int position) {
        CommunityLandingModel communityLandingModel=communityLandingModels.get(position);
        holder.title.setText(String.valueOf(communityLandingModel.getTitle()));
        holder.description.setText(String.valueOf(communityLandingModel.getDescription()));
    }

    @Override
    public int getItemCount() {
        return communityLandingModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title,description;
        private View notificationBar;
        private final Context context;
        private OnItemClickListener onClickListener;
        public ViewHolder(@NonNull View itemView, OnItemClickListener onClickListener) {
            super(itemView);
            notificationBar=itemView.findViewById(R.id.notifiactionBar);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);
            this.onClickListener=onClickListener;
            itemView.setOnClickListener(this);
            context=itemView.getContext();
        }

        @Override
        public void onClick(View v) {
//            onClickListener.onProfileClick(getAdapterPosition());
//            onClickListener.onGroupsClick(getAdapterPosition());
//            onClickListener.onPeopleClick(getAdapterPosition());
            final Intent intent;
            switch (getAdapterPosition()){
                case 0:
                    intent =  new Intent(context, ProfileActivity.class);
                    break;

                case 1:
                    intent =  new Intent(context, PeopleActivity.class);
                    break;
                case 2:
                    intent =  new Intent(context, GroupsActivity.class);
                    break;
                default:
                    intent =  new Intent(context, CommunityActivity.class);
                    break;
            }
            context.startActivity(intent);
        }
    }
    public interface OnItemClickListener {
        void onProfileClick(int position);
        void onPeopleClick(int position);
        void onGroupsClick(int position);
    }
}
