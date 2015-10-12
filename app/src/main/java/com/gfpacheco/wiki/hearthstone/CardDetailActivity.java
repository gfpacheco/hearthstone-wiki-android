package com.gfpacheco.wiki.hearthstone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CardDetailActivity extends AppCompatActivity {

    private static final String EXTRA_CARD_ID = "cardId";

    public static Intent getIntent(Context context, Card card) {
        Intent intent = new Intent(context, CardDetailActivity.class);
        intent.putExtra(EXTRA_CARD_ID, card.cardId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_detail);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, CardDetailFragment.getInstance(getIntent().getStringExtra(EXTRA_CARD_ID)))
                .disallowAddToBackStack()
                .commit();
    }
}
