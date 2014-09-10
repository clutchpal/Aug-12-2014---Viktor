package com.loyallite;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;
import android.widget.ImageView;


public class DealAdapterRightPane extends BaseAdapter {

	 Context context;
	 List<DealMenuRowItem> rowItems;

	 DealAdapterRightPane (Context context, List<DealMenuRowItem> rowItems) {
	  this.context = context;
	  this.rowItems = rowItems;
	 }

	 @Override
	 public int getCount() {
	  return rowItems.size();
	 }

	 @Override
	 public Object getItem(int position) {
	  return rowItems.get(position);
	 }

	 @Override
	 public long getItemId(int position) {
	  return rowItems.indexOf(getItem(position));
	 }

	 /* private view holder class */
	 private class ViewHolder {
	  ImageView deal_pic;
	  TextView deal_name;
	  TextView deal_cost;
	  TextView deal_description;
	 }

	 @Override
	 public View getView(int position, View convertView, ViewGroup parent) {

	  ViewHolder holder = null;

	  LayoutInflater mInflater = (LayoutInflater) context
	    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	  if (convertView == null) {
	   convertView = mInflater.inflate(R.layout.hubmenu_list_item, null);
	   holder = new ViewHolder();

	   holder.deal_name = (TextView) convertView
	     .findViewById(R.id.Deal_name);
	   holder.deal_pic = (ImageView) convertView
	     .findViewById(R.id.Deal_pic);
	   holder.deal_cost = (TextView) convertView.findViewById(R.id.Deal_cost);
	   holder.deal_description = (TextView) convertView
	     .findViewById(R.id.Deal_description);

	   DealMenuRowItem row_pos = rowItems.get(position);

	   holder.deal_pic.setImageResource(row_pos.getDeal_pic_id());
	   holder.deal_name.setText(row_pos.getDeal_name());
	   holder.deal_cost.setText(row_pos.getDeal_cost());
	   holder.deal_description.setText(row_pos.getDeal_description());

	   convertView.setTag(holder);
	  } else {
	   holder = (ViewHolder) convertView.getTag();
	  }

	  return convertView;
	 }

	}