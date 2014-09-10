package com.loyallite;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class HubMenuFragmentoldversion extends Activity implements OnItemClickListener {

 String[] member_names;
 TypedArray profile_pics;
 String[] statues;
 String[] contactType;

 List<DealMenuRowItem> rowItems;
 ListView mylistview;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.hubmenu_layout);

  rowItems = new ArrayList<DealMenuRowItem>();

  member_names = getResources().getStringArray(R.array.Deal_name);

  profile_pics = getResources().obtainTypedArray(R.array.Deal_pic);

  statues = getResources().getStringArray(R.array.Deal_cost);

  contactType = getResources().getStringArray(R.array.Deal_description);

  for (int i = 0; i < member_names.length; i++) {
   DealMenuRowItem item = new DealMenuRowItem(member_names[i],
     profile_pics.getResourceId(i, -1), statues[i],
     contactType[i]);
   rowItems.add(item);
  }

  mylistview = (ListView) findViewById(R.id.userhubmenu);
  DealAdapterRightPane adapter = new DealAdapterRightPane(this, rowItems);
  mylistview.setAdapter(adapter);
  profile_pics.recycle();
  mylistview.setOnItemClickListener(this);

 }

 @Override
 public void onItemClick(AdapterView<?> parent, View view, int position,
   long id) {

  String member_name = rowItems.get(position).getDeal_name();
  Toast.makeText(getApplicationContext(), "" + member_name,
    Toast.LENGTH_SHORT).show();
 }

}
