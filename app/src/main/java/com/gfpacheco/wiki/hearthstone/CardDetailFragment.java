package com.gfpacheco.wiki.hearthstone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CardDetailFragment extends Fragment implements LoaderManager.LoaderCallbacks<Card> {

    private static final String ARGUMENT_CARD_ID = "cardId";

    public static CardDetailFragment getInstance(String cardId) {
        Bundle arguments = new Bundle();
        arguments.putString(ARGUMENT_CARD_ID, cardId);

        CardDetailFragment fragment = new CardDetailFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    private TextView mTextViewName;
    private ImageView mImageViewCover;

    public CardDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(0, getArguments(), this).forceLoad();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_card_detail, container, false);

        mTextViewName = (TextView) rootView.findViewById(R.id.text_view_name);
        mImageViewCover = (ImageView) rootView.findViewById(R.id.image_view_cover);

        return rootView;
    }

    @Override
    public Loader<Card> onCreateLoader(int id, Bundle args) {
        return new CardLoader(getActivity(), args.getString(ARGUMENT_CARD_ID));
    }

    @Override
    public void onLoadFinished(Loader<Card> loader, Card card) {
        mTextViewName.setText(card.name);
        Picasso.with(getActivity()).load(card.img).into(mImageViewCover);
    }

    @Override
    public void onLoaderReset(Loader<Card> loader) {

    }
}
