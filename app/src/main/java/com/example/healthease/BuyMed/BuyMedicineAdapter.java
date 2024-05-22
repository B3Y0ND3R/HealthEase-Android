package com.example.healthease.BuyMed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.healthease.R;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * The BuyMedicineAdapter class is an adapter that provides views
 * for displaying medicine details in a list.
 *
 */
public class BuyMedicineAdapter extends BaseAdapter {
    private ArrayList<HashMap<String, String>> data;
    private LayoutInflater inflater;


    /**
     * Constructs a new {@code BuyMedicineAdapter} with the specified context and data.
     *
     * @param context The context used to access system services.
     * @param data The data to be displayed in the list.
     */
    public BuyMedicineAdapter(Context context, ArrayList<HashMap<String, String>> data) {
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * Sets the layout inflater.
     *
     * @param inflater The layout inflater to be used.
     */
    public void setInflater(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    /**
     * Returns the number of items in the data set.
     *
     * @return The number of items in the data set.
     */
    @Override
    public int getCount() {
        return data.size();
    }

    /**
     * Returns the data item associated with the specified position.
     *
     * @param position The position of the item within the data set.
     * @return The data item at the specified position.
     */
    @Override
    public HashMap<String, String> getItem(int position) {
        return data.get(position);
    }

    /**
     * Returns the row ID associated with the specified position.
     *
     * @param position The position of the item within the data set.
     * @return The ID of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Returns a view for the data item at the specified position in the data set.
     *
     * @param position The position of the item within the data set.
     * @param convertView The old view to reuse, if possible.
     * @param parent The parent view that this view will be attached to.
     * @return A view corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.multi_lines, null);
        TextView line1 = vi.findViewById(R.id.line_a);
        TextView line2 = vi.findViewById(R.id.line_b);
        TextView line3 = vi.findViewById(R.id.line_c);
        TextView line4 = vi.findViewById(R.id.line_d);
        TextView line5 = vi.findViewById(R.id.line_e);

        HashMap<String, String> item = data.get(position);

        line1.setText(item.get("line1"));
        line2.setText(item.get("line2"));
        line3.setText(item.get("line3"));
        line4.setText(item.get("line4"));
        line5.setText(item.get("line5"));

        return vi;
    }
}

