package com.loyallite;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DealItemAdapter extends ArrayAdapter<String> {

    private String[] mDealItems;
    private Context mDealContext;

    public DealItemAdapter(Context context, String[] dealMenuItemList) {
        super(context, R.layout.dealmenu_layout, dealMenuItemList);
        mDealContext = context;
        mDealItems = dealMenuItemList;
    }

    @Override
    public int getCount() {
        return mDealItems.length;
    }

    @Override
    public String getItem(int position) {
        return mDealItems[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inf = (LayoutInflater) mDealContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout layoutToDisplay = (LinearLayout) inf.inflate(
                R.layout.dealmenuitem_layout, parent, false);
        TextView textToDisplay = (TextView) layoutToDisplay.findViewById(R.id.dealtext);
        textToDisplay.setText(mDealItems[position]);


        return layoutToDisplay;
    }
}
