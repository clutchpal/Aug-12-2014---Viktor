package com.loyallite;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

import com.loyallite.DealMenuFragmentRightPane.HubMenuListener4;
import com.loyallite.HubMenuFragmentLeftPane.HubMenuListener;

public class HubActivity extends ActionBarActivity implements HubMenuListener, HubMenuListener4 {
    
    private SlidingPaneLayout mPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hub_activity);
        
        HubMenuFragmentLeftPane menuFragment = new HubMenuFragmentLeftPane();
        HubContentFragment content = new HubContentFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.leftpane, menuFragment);
        ft.add(R.id.rightpane, content);
        ft.commit();
        
        mPane = (SlidingPaneLayout) findViewById(R.id.sp);
        mPane.setPanelSlideListener(new PaneListener());

        if (!mPane.isSlideable()) {
            menuFragment.setHasOptionsMenu(false);
            content.setHasOptionsMenu(true);
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
    
    	Log.e("mytag", "position hub menu: "+position);
    	if(position == 2)
    	{
    		DealMenuFragmentRightPane newFragment = new DealMenuFragmentRightPane();
    		Bundle args = new Bundle();
    		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    		transaction.replace(R.id.rightpane, newFragment, "deal_menu");
    		transaction.addToBackStack("rightpane").commit();
    	}
    	
        
        
    }
}
