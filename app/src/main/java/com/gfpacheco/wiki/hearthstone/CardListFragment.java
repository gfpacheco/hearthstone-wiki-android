package com.gfpacheco.wiki.hearthstone;


import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CardListFragment extends ListFragment {

    Card[] mCardsArray = {
            new Card("Anduin Wrynn"),
            new Card("Berserking"),
            new Card("Blessing of Kings")
    };

    public CardListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_card_list, container);

        setListAdapter(new CardAdapter(getActivity(), mCardsArray));

        return rootView;
    }

}
