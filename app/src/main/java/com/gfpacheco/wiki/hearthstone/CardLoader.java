package com.gfpacheco.wiki.hearthstone;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CardLoader extends AsyncTaskLoader<Card> {

    private final String mCardId;

    public CardLoader(Context context, String cardId) {
        super(context);
        mCardId = cardId;
    }

    @Override
    public Card loadInBackground() {
        Card card = null;
        try {
            URL url = new URL("https://omgvamp-hearthstone-v1.p.mashape.com/cards/" + mCardId);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.addRequestProperty("X-Mashape-Key", "h2WjeYC7rsmshvibIZj521gFCLo8p1M8P6VjsnTp2lmskXOwFa");

            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
                Gson gson = new Gson();

                reader.beginArray();
                if (reader.hasNext()) {
                    card = gson.fromJson(reader, Card.class);
                }            } finally {
                urlConnection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return card;
    }

}
