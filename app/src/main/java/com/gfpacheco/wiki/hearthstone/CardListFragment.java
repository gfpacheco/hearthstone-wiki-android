package com.gfpacheco.wiki.hearthstone;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.ListView;

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
        return new CardListLoader(getActivity());
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

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        ((OnListItemClickCallback) getActivity()).onListItemClick(mAdapter.getItem(position));
    }

    public interface OnListItemClickCallback {
        void onListItemClick(Card card);
    }

}
