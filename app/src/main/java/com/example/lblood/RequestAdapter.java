package com.example.lblood;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RequestAdapter {


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

    @Override
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

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_resut_list, null, true);


            holder.id = (TextView) convertView.findViewById(R.id.text1);
            holder.st = (TextView) convertView.findViewById(R.id.text2);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }


        holder.id.setText(dataModelArrayList.get(position).getMonth());

        if( dataModelArrayList.get(position).getPayment_state()==true){

            holder.st.setText("Payed");
            holder.st.setTextColor(Color.parseColor("#59f442"));

        }
        else{

            holder.st.setText("not Payed");

            holder.st.setTextColor(Color.parseColor("#f20909"));


        }

        return convertView;
    }

    private class ViewHolder {

        protected TextView  id,st;

    }

}
