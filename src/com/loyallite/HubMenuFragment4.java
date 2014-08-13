package com.loyallite;

import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
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

public class HubMenuFragment4 extends Fragment {

 String[] member_names;
 TypedArray profile_pics;
 String[] statues;
 String[] contactType;

 List<HubMenuRowItem> rowItems;

 
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
 
  

  member_names = getResources().getStringArray(R.array.Member_names);

  profile_pics = getResources().obtainTypedArray(R.array.profile_pics);

  statues = getResources().getStringArray(R.array.statues);

  contactType = getResources().getStringArray(R.array.contactType);

  for (int i = 0; i < member_names.length; i++) {
   HubMenuRowItem item = new HubMenuRowItem(member_names[i],
     profile_pics.getResourceId(i, -1), statues[i],
     contactType[i]);
   rowItems.add(item);
  }
 }

 
 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
         Bundle savedInstanceState) {
	 View v = inflater.inflate(R.layout.hubmenu_layout, container, false);
	 ListView slidingPaneListView = (ListView) v
             .findViewById(R.id.userhubmenu);
	 
	 rowItems = new ArrayList<HubMenuRowItem>();
	 
	 // Setting the items for the list view
    final HubMenuAdapter2 menuAdapter2 = new HubMenuAdapter2(
             getActivity(), rowItems);
     slidingPaneListView.setAdapter(menuAdapter2);
     
  // Setting item onclick listener
     slidingPaneListView
             .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                 @Override
                 public void onItemClick(AdapterView<?> parent, View view,
                         int position, long id) {
                     // Passing item clicked event onto whoever is listening
                     mMenuListener4.onMenuItemClick(position);
                     menuAdapter2.getItem(position);
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
