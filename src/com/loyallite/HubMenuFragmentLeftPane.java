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

public class HubMenuFragmentLeftPane extends Fragment {

    private HubMenuListener mMenuListener;
    
    @Override
    public void onAttach(Activity activity) {
        if (!(activity instanceof HubMenuListener)) {
            throw new ClassCastException();
        } else {
            // Setting listener from received activity
            mMenuListener = (HubMenuListener) activity;
        }

        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.hubmenu_layout, null);
        ListView slidingPaneListView = (ListView) v
                .findViewById(R.id.userhubmenu);
        
        // Setting the items for the list view
        HubMenuAdapterLeftPane menuAdapter = new HubMenuAdapterLeftPane(
                getActivity(), getResources().getStringArray(
                        R.array.userhubmenulist));
        slidingPaneListView.setAdapter(menuAdapter);
        
        // Setting item onclick listener
        slidingPaneListView
                .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
                        // Passing item clicked event onto whoever is listening
                        mMenuListener.onMenuItemClick(position);
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
    public interface HubMenuListener {
        /**
         * Triggers when sliding pane menu item is clicked
         */
        public void onMenuItemClick(int position);
        
    }
}
