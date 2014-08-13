package com.loyallite;



import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import android.widget.Toast;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class DealItemFragment extends Fragment {

    private DealItemListener mDealItemListener;
    
    @Override
    public void onAttach(Activity activity) {
        if (!(activity instanceof DealItemListener)) {
            throw new ClassCastException();
        } else {
            // Setting listener from received activity
            mDealItemListener = (DealItemListener) activity;
        }

        super.onAttach(activity);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.dealitem_layout, container, false);
        ListView DealListView = (ListView) v
                .findViewById(R.id.dealmenu);
        
        // Setting the items for the list view
        DealItemAdapter dealitemAdapter = new DealItemAdapter(
                getActivity(), getResources().getStringArray(
                        R.array.dealitemlist));
        DealListView.setAdapter(dealitemAdapter);
        
        // Setting item onclick listener
        DealListView
                .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
                    	mDealItemListener.onMenuItemClick(position);
                    }
                });
        setHasOptionsMenu(true);
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.dealmenu_actionbar_optionmenu, menu);
    }

    /**
     * Communication link between components that want to communicate with this
     * type of fragment
     */
    public interface DealItemListener {
        /**
         * Triggers when menu item is clicked
         */
        public void onMenuItemClick(int position);
    }
}