package com.gfpacheco.wiki.hearthstone;


import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;

import java.util.List;

public class CardListFragment extends ListFragment implements LoaderManager.LoaderCallbacks<List<Card>> {

    private CardAdapter mAdapter;

    public CardListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mAdapter = new CardAdapter(getActivity());
        setListAdapter(mAdapter);

        setListShown(false);

        getLoaderManager().initLoader(0, null, this).forceLoad();
    }

    @Override
    public Loader<List<Card>> onCreateLoader(int id, Bundle args) {
        return new CardLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<Card>> loader, List<Card> data) {
        mAdapter.setData(data);

        if (isResumed()) {
            setListShown(true);
        } else {
            setListShownNoAnimation(true);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Card>> loader) {
        mAdapter.setData(null);
    }
}
