package com.gfpacheco.wiki.hearthstone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CardListActivity extends AppCompatActivity {

    String[] mCardsArray = {
            "Anduin Wrynn",
            "Berserking",
            "Blessing of Kings"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        ListView cardListView = (ListView) findViewById(R.id.card_list_view);
        cardListView.setAdapter(new ArrayAdapter<>(this, R.layout.list_item_card, mCardsArray));
    }
}
