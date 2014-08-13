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

public class DealMenuFragment extends Fragment {

    private DealMenuListener mDealListener;
    
    @Override
    public void onAttach(Activity activity) {
        if (!(activity instanceof DealMenuListener)) {
            throw new ClassCastException();
        } else {
            // Setting listener from received activity
            mDealListener = (DealMenuListener) activity;
        }

        super.onAttach(activity);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.dealmenu_layout, container, false);
        ListView DealListView = (ListView) v
                .findViewById(R.id.dealmenu);
        
        // Setting the items for the list view
        DealMenuAdapter dealAdapter = new DealMenuAdapter(
                getActivity(), getResources().getStringArray(
                        R.array.dealmenulist));
        DealListView.setAdapter(dealAdapter);
        
        // Setting item onclick listener
        DealListView
                .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
                    	mDealListener.onMenuItemClick(position);
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
    public interface DealMenuListener {
        /**
         * Triggers when menu item is clicked
         */
        public void onMenuItemClick(int position);
    }
    
  
    public void onMenuItemClick(int position) {
    	
    	if(position == 0)
    	{
    		DealMenuFragment newFragment = new DealMenuFragment();
    		Bundle args = new Bundle();
    		FragmentTransaction transaction = getFragmentManager().beginTransaction();
    		transaction.replace(R.id.rightpane, newFragment);
    		transaction.addToBackStack(null);
    		
    		transaction.commit();
    	}
    
}
} 
