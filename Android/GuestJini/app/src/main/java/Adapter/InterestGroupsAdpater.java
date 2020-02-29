package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carmel.guestjini.R;

import java.util.ArrayList;

import Model.InterestGroupsModel;
import Model.MyTicketsModel;

import static Model.InterestGroupsModel.FOURTH_TYPE;
import static Model.InterestGroupsModel.THIRD_TYPE;
import static Model.MyTicketsModel.ONE_TYPE;
import static Model.MyTicketsModel.TWO_TYPE;

public class InterestGroupsAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<InterestGroupsModel> modelArrayList;

    public InterestGroupsAdpater(ArrayList<InterestGroupsModel> interestGroupsList) {
        this.modelArrayList=interestGroupsList;
    }
    @Override
    public int getItemViewType(int position) {
        InterestGroupsModel interestGroupsModel=modelArrayList.get(position);
        if(interestGroupsModel!=null){
            return interestGroupsModel.getViewType();
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case ONE_TYPE:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.subscribed_interest_group_container,parent,false);
                return new InterestGroupsAdpater.OneViewHolder(view);

            case TWO_TYPE:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.subscribed_read_interest_group_cell,parent,false);
                return new InterestGroupsAdpater.SecondViewHolder(view);
            case THIRD_TYPE:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.unsubscribed_interest_group_container,parent,false);
                return new InterestGroupsAdpater.ThirdViewHolder(view);

            case FOURTH_TYPE:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.unsubscribed_interest_group_does_not_match_cell,parent,false);
                return new InterestGroupsAdpater.FourthViewHolder(view);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    class OneViewHolder extends RecyclerView.ViewHolder{

         public OneViewHolder(@NonNull View itemView) {
             super(itemView);
         }
     }
    class SecondViewHolder extends RecyclerView.ViewHolder{

        public SecondViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    class ThirdViewHolder extends RecyclerView.ViewHolder{
        TextView interestCategoryTitle,interestGroupTitle,interestGroupDescription,indicatorDescription;
        ImageView indicators,informationIcons;
        public ThirdViewHolder(@NonNull View itemView) {
            super(itemView);
            interestCategoryTitle=itemView.findViewById(R.id.interestCategoryTitle);
            interestGroupTitle=itemView.findViewById(R.id.interestGroupTitle);
            interestGroupDescription=itemView.findViewById(R.id.interestGroupDescription);
            indicatorDescription=itemView.findViewById(R.id.indicatorSmallDescription);
            indicators=itemView.findViewById(R.id.interestGroupIndicator);
            informationIcons=itemView.findViewById(R.id.informationIcon);
            indicators.setImageResource(R.drawable.indicator_icon);
            informationIcons.setImageResource(R.drawable.information_icon);
        }
    }
    class FourthViewHolder extends RecyclerView.ViewHolder{
        TextView interestCategoryTitle,interestGroupTitle,interestGroupDescription;
        ImageView indicators,informationIcons;
        public FourthViewHolder(@NonNull View itemView) {
            super(itemView);
            interestCategoryTitle=itemView.findViewById(R.id.interestCategoryTitle);
            interestGroupTitle=itemView.findViewById(R.id.interestGroupTitle);
            interestGroupDescription=itemView.findViewById(R.id.interestGroupDescription);
            informationIcons=itemView.findViewById(R.id.informationIcon);
        }
    }
//    private ArrayList<InterestGroupsModel> interestGroupsList;
//    public InterestGroupsAdpater(ArrayList<InterestGroupsModel> interestGroupsList) {
//        this.interestGroupsList=interestGroupsList;
//    }
//
//    @NonNull
//    @Override
//    public InterestGroupsAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.unsubscribed_interest_group_container,parent,false);
//        ViewHolder viewHolder=new ViewHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull InterestGroupsAdpater.ViewHolder holder, int position) {
////        final InterestGroupsModel interestGroupsModel=this.interestGroupsList.get(position);
////        holder.interestCategoryTitle.setText(String.valueOf(interestGroupsModel.getAddInterestCategoryTitle()));
////        holder.interestGroupTitle.setText(String.valueOf(interestGroupsModel.getAddInterestGroupTitle()));
////        holder.interestGroupDescription.setText(String.valueOf(interestGroupsModel.getAddInterestGroupDescription()));
////        holder.indicatorDescription.setText(String.valueOf(interestGroupsModel.getAddIndicatorDescription()));
////        holder.indicators.setImageResource(interestGroupsModel.getAddIndicator());
////        holder.informationIcons.setImageResource(interestGroupsModel.getAddInformationIcons());
//    }
//
//    @Override
//    public int getItemCount() {
//        return interestGroupsList.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        TextView interestCategoryTitle,interestGroupTitle,interestGroupDescription,indicatorDescription;
//        ImageView indicators,informationIcons;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            interestCategoryTitle=itemView.findViewById(R.id.interestCategoryTitle);
//            interestGroupTitle=itemView.findViewById(R.id.interestGroupTitle);
//            interestGroupDescription=itemView.findViewById(R.id.interestGroupDescription);
//            indicatorDescription=itemView.findViewById(R.id.indicatorSmallDescription);
//            indicators=itemView.findViewById(R.id.interestGroupIndicator);
//            informationIcons=itemView.findViewById(R.id.informationIcon);
//            indicators.setImageResource(R.drawable.indicator_icon);
//            informationIcons.setImageResource(R.drawable.information_icon);
//        }
//    }
}
