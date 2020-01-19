package com.example.lblood;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RequestAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<RequestModel> dataModelArrayList;

    public RequestAdapter(Context context, ArrayList<RequestModel> dataModelArrayList) {

        this.context = context;
        this.dataModelArrayList = dataModelArrayList;
    }

    @Override
    public int getViewTypeCount(){


        if(getCount() > 0){
            return getCount();
        }else{
            return super.getViewTypeCount();
        }
    }
    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return dataModelArrayList.size();
    }

    public Object getItem(int position) {
        return dataModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        // the getTag returns the viewHolder object set as a tag to the view
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.resultlist, null, true);


            holder.name = (TextView) convertView.findViewById(R.id.text1);
            holder.age = (TextView) convertView.findViewById(R.id.text2);

            convertView.setTag(holder);
        }else holder = (ViewHolder) convertView.getTag();


        holder.name.setText(dataModelArrayList.get(position).getfullName());


         holder.age.setText(dataModelArrayList.get(position).getAge());



        return convertView;
    }

    private class ViewHolder {

        protected TextView  name,age;

    }

}
