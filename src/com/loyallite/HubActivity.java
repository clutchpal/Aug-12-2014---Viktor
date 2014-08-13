package com.loyallite;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.app.ListFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.loyallite.DealMenuFragment.DealMenuListener;
import com.loyallite.HubMenuFragment.HubMenuListener;
import com.loyallite.HubMenuFragment4.HubMenuListener4;

public class HubActivity extends ActionBarActivity implements HubMenuListener, DealMenuListener, HubMenuListener4 {
    
    private SlidingPaneLayout mPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hub_activity);
        mPane = (SlidingPaneLayout) findViewById(R.id.sp);
        mPane.setPanelSlideListener(new PaneListener());

        if (!mPane.isSlideable()) {
            getSupportFragmentManager().findFragmentById(R.id.leftpane)
                    .setHasOptionsMenu(false);
            getSupportFragmentManager().findFragmentById(R.id.rightpane)
                    .setHasOptionsMenu(true);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private class PaneListener implements SlidingPaneLayout.PanelSlideListener {

        @Override
        public void onPanelClosed(View view) {
            getSupportFragmentManager().findFragmentById(R.id.leftpane)
                    .setHasOptionsMenu(false);
            getSupportFragmentManager().findFragmentById(R.id.rightpane)
                    .setHasOptionsMenu(true);
        }

        @Override
        public void onPanelOpened(View view) {
            getSupportFragmentManager().findFragmentById(R.id.leftpane)
                    .setHasOptionsMenu(true);
            getSupportFragmentManager().findFragmentById(R.id.rightpane)
                    .setHasOptionsMenu(false);
        }

        @Override
        public void onPanelSlide(View view, float arg1) {
        }
    }

    @Override
    public void onMenuItemClick(int position) {
    	
    	if(position == 2)
    	{
    		HubMenuFragment4 newFragment = new HubMenuFragment4();
    		Bundle args = new Bundle();
    		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    		transaction.replace(R.id.rightpane, newFragment);
    		transaction.addToBackStack(null);
    		
    		transaction.commit();
    	}
    	
        
        
    }
}
