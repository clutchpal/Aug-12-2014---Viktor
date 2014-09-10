package com.loyallite;

import java.util.ArrayList;
import java.util.List;




import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.ViewGroup;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.app.ListFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class DealMenuFragmentRightPane extends Fragment {

 String[] deal_name;
 TypedArray deal_pic;
 String[] deal_cost;
 String[] deal_description;

 List<DealMenuRowItem> rowItems;

 
 private HubMenuListener4 mMenuListener4;
 
 @Override
 public void onAttach(Activity activity) {
     if (!(activity instanceof HubMenuListener4)) {
         throw new ClassCastException();
     } else {
         // Setting listener from received activity
         mMenuListener4 = (HubMenuListener4) activity;
     }

     super.onAttach(activity);
 }
 
 
 @Override
 public void onActivityCreated(Bundle savedInstanceState) {

     super.onActivityCreated(savedInstanceState);
 
  

  deal_name = getResources().getStringArray(R.array.Deal_name);

  deal_pic = getResources().obtainTypedArray(R.array.Deal_pic);

  deal_cost = getResources().getStringArray(R.array.Deal_cost);

  deal_description = getResources().getStringArray(R.array.Deal_description);

  for (int i = 0; i < deal_name.length; i++) {
   DealMenuRowItem item = new DealMenuRowItem(deal_name[i],
     deal_pic.getResourceId(i, -1), deal_cost[i],
     deal_description[i]);
   rowItems.add(item);
  }
 }

 
 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
         Bundle savedInstanceState) {
	 View v = inflater.inflate(R.layout.hubmenu_layout, null);
	 ListView slidingPaneListView = (ListView) v
             .findViewById(R.id.userhubmenu);
	 
	 rowItems = new ArrayList<DealMenuRowItem>();
	 
	 // Setting the items for the list view
    final DealAdapterRightPane menuAdapter2 = new DealAdapterRightPane(
             getActivity(), rowItems);
     slidingPaneListView.setAdapter(menuAdapter2);
     
  // Setting item onclick listener
     slidingPaneListView
             .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                 @Override
                 public void onItemClick(AdapterView<?> parent, View view,
                         int position, long id) {
                		Log.e("mytag", "position: "+position);
                	 	if(position == 1)
                	 	{
                	 		DealItemFragmentRightPane newFragment2 = new DealItemFragmentRightPane();
                	 		Bundle args = new Bundle();
                	 		FragmentTransaction transaction = getFragmentManager().beginTransaction();
                	 		transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                	 		transaction.replace(R.id.rightpane, newFragment2, "dealitem");
                	 		transaction.addToBackStack("dealitem");
                	 		transaction.commit();
                	 	}
                 }
             });
     setHasOptionsMenu(true);
	  return v;
 }
 

 @Override
 public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
     super.onCreateOptionsMenu(menu, inflater);
     inflater.inflate(R.menu.hubmenu_actionbar_optionmenu, menu);
 }

 /**
  * Communication link between components that want to communicate with this
  * type of fragment
  */
 public interface HubMenuListener4 {
     /**
      * Triggers when sliding pane menu item is clicked
      */
     public void onMenuItemClick(int position);
     
 }
 
 

}
