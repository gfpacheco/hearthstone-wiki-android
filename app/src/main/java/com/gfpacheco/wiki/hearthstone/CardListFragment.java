package com.gfpacheco.wiki.hearthstone;


import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class CardListFragment extends ListFragment {

    String[] mCardsArray = {
            "Anduin Wrynn",
            "Berserking",
            "Blessing of Kings"
    };

    public CardListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_card_list, container);

        setListAdapter(new ArrayAdapter<>(getActivity(), R.layout.list_item_card, mCardsArray));

        return rootView;
    }

}
