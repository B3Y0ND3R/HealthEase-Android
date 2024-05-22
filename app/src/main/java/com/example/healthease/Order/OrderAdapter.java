package com.example.healthease.Order;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.healthease.R;

import java.util.ArrayList;

/**
 * OrderAdapter is a custom adapter used to display a list of orders in a ListView.
 * Each order contains multiple lines of information which are displayed in a custom layout.
 */
public class OrderAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> orderData;

    /**
     * Constructs a new OrderAdapter.
     *
     * @param context the context in which the adapter is running
     * @param orderData the list of order data to be displayed
     */
    public OrderAdapter(Context context, ArrayList<String> orderData) {
        this.context = context;
        this.orderData = orderData;
    }

    /**
     * Returns the number of orders in the list.
     *
     * @return the number of orders
     */
    @Override
    public int getCount() {
        return orderData.size();
    }

    /**
     * Returns the order at the specified position.
     *
     * @param position the position of the item within the adapter's data set
     * @return the order at the specified position
     */
    @Override
    public Object getItem(int position) {
        return orderData.get(position);
    }

    /**
     * Returns the row ID associated with the specified position.
     *
     * @param position the position of the item within the adapter's data set
     * @return the ID of the item at the specified position
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set.
     *
     * @param position the position of the item within the adapter's data set
     * @param convertView the old view to reuse, if possible
     * @param parent the parent that this view will eventually be attached to
     * @return a View corresponding to the data at the specified position
     */
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