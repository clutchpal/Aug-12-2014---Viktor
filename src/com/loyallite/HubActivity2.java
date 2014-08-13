package com.loyallite;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;


import com.loyallite.HubMenuFragment.HubMenuListener;

public class HubActivity2 extends ActionBarActivity implements HubMenuListener {
    
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
        // TODO Do something for each menu item
        Toast.makeText(this, "Item " + position, Toast.LENGTH_SHORT).show();
        
        
    }
}