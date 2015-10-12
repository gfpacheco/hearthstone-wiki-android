package com.gfpacheco.wiki.hearthstone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CardListActivity extends AppCompatActivity implements CardListFragment.OnListItemClickCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);
    }

    @Override
    public void onListItemClick(Card card) {
        startActivity(CardDetailActivity.getIntent(this, card));
    }

}
