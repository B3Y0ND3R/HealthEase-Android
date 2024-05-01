package com.example.healthease.Order;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.healthease.R;

import java.util.ArrayList;

public class OrderAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> orderData;

    public OrderAdapter(Context context, ArrayList<String> orderData) {
        this.context = context;
        this.orderData = orderData;
    }

    @Override
    public int getCount() {
        return orderData.size();
    }

    @Override
    public Object getItem(int position) {
        return orderData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.multi_lines, parent, false);
        }

        TextView lineA = convertView.findViewById(R.id.line_a);
        TextView lineB = convertView.findViewById(R.id.line_b);
        TextView lineC = convertView.findViewById(R.id.line_c);
        TextView lineD = convertView.findViewById(R.id.line_d);
        TextView lineE = convertView.findViewById(R.id.line_e);

        // Assuming orderData is in correct format
        String[] strData = orderData.get(position).split("\\$");

        lineA.setText(strData[0]);
        lineB.setText(strData[1]);
        lineC.setText("Tk." + strData[6]);

        if (strData[7].equals("medicine")) {
            lineD.setText("Del:" + strData[4]);
        } else {
            lineD.setText("Del:" + strData[4] + " " + strData[5]);
        }

        lineE.setText(strData[7]);

        return convertView;
    }
}
