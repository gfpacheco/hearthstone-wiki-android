package com.gfpacheco.wiki.hearthstone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CardDetailFragment extends Fragment {

    private static final String ARGUMENT_CARD_ID = "cardId";

    public static CardDetailFragment getInstance(String cardId) {
        Bundle arguments = new Bundle();
        arguments.putString(ARGUMENT_CARD_ID, cardId);

        CardDetailFragment fragment = new CardDetailFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    public CardDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_card_detail, container, false);
    }

}
