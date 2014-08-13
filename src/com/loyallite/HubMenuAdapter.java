package com.loyallite;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HubMenuAdapter extends ArrayAdapter<String> {

    private String[] mMenuItems;
    private Context mContext;

    public HubMenuAdapter(Context context, String[] menuItemList) {
        super(context, R.layout.hubmenuitem_layout, menuItemList);
        mContext = context;
        mMenuItems = menuItemList;
    }

    @Override
    public int getCount() {
        return mMenuItems.length;
    }

    @Override
    public String getItem(int position) {
        return mMenuItems[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inf = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout layoutToDisplay = (LinearLayout) inf.inflate(
                R.layout.hubmenuitem_layout, parent, false);
        TextView textToDisplay = (TextView) layoutToDisplay.findViewById(R.id.itemtext);
        textToDisplay.setText(mMenuItems[position]);

        return layoutToDisplay;
    }
}