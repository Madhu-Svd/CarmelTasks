package com.carmel.materialactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Model.JsonModel;

class WatchAdapter extends BaseAdapter {
    Context context;
    List<JsonModel> dataList;

    private View vi;
    private ViewHolder viewHolder;
    private static LayoutInflater inflater = null;

    public WatchAdapter(Context context, List<JsonModel> dataList){
        this.context = context;
        this.dataList = dataList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        vi = convertView;
        //Populate the Listview
        final int pos = position;
        JsonModel jsonModel = dataList.get(pos);
        if(vi == null) {
            vi = inflater.inflate(R.layout.list_item_watch, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) vi.findViewById(R.id.watchnameTxt);
            viewHolder.price = (TextView) vi.findViewById(R.id.watchpriceTxt);
            vi.setTag(viewHolder);
        }else
            viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.name.setText(jsonModel.getName());
        viewHolder.price.setText(jsonModel.getPrice());

        return vi;
    }
    public class ViewHolder{
        TextView name;
        TextView price;
    }
}
