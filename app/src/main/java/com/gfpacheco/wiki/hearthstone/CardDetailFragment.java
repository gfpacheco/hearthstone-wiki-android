package com.gfpacheco.wiki.hearthstone;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.text.Html;
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

    private ImageView mImageViewCover;
    private TextView mTextViewName;
    private TextView mTextViewType;
    private TextView mTextViewText;
    private TextView mTextViewCost;
    private TextView mTextViewAttack;
    private TextView mTextViewHealth;

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

        mImageViewCover = (ImageView) rootView.findViewById(R.id.image_view_cover);
        mTextViewName = (TextView) rootView.findViewById(R.id.text_view_name);
        mTextViewType = (TextView) rootView.findViewById(R.id.text_view_type);
        mTextViewText = (TextView) rootView.findViewById(R.id.text_view_text);
        mTextViewCost = (TextView) rootView.findViewById(R.id.text_view_cost);
        mTextViewAttack = (TextView) rootView.findViewById(R.id.text_view_attack);
        mTextViewHealth = (TextView) rootView.findViewById(R.id.text_view_health);

        return rootView;
    }

    @Override
    public Loader<Card> onCreateLoader(int id, Bundle args) {
        return new CardLoader(getActivity(), args.getString(ARGUMENT_CARD_ID));
    }

    @Override
    public void onLoadFinished(Loader<Card> loader, Card card) {
        Context context = getActivity();
        Picasso.with(context).load(card.img).into(mImageViewCover);
        mTextViewName.setText(card.name);
        mTextViewType.setText(card.type);
        if (card.text != null) mTextViewText.setText(Html.fromHtml(card.text));
        mTextViewCost.setText(context.getString(R.string.card_detail_cost, card.cost));
        mTextViewAttack.setText(context.getString(R.string.card_detail_attack, card.attack));
        mTextViewHealth.setText(context.getString(R.string.card_detail_health, card.health));
    }

    @Override
    public void onLoaderReset(Loader<Card> loader) {

    }
}
