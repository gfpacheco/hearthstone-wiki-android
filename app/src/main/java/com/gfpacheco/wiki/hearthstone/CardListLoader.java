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
import java.util.ArrayList;
import java.util.List;

public class CardListLoader extends AsyncTaskLoader<List<Card>> {

    public CardListLoader(Context context) {
        super(context);
    }

    @Override
    public List<Card> loadInBackground() {
        List<Card> cards = new ArrayList<>();
        try {
            URL url = new URL("https://omgvamp-hearthstone-v1.p.mashape.com/cards/sets/Basic?cost=1");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.addRequestProperty("X-Mashape-Key", "h2WjeYC7rsmshvibIZj521gFCLo8p1M8P6VjsnTp2lmskXOwFa");

            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
                Gson gson = new Gson();

                reader.beginArray();
                while (reader.hasNext()) {
                    cards.add(gson.<Card>fromJson(reader, Card.class));
                }
            } finally {
                urlConnection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cards;
    }

}
